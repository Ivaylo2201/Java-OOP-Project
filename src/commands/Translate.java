package commands;

import helpers.FigureMapperString;
import interfaces.CommandWithParams;
import interfaces.Figure;
import managers.FileManager;
import java.io.*;
import java.util.List;

/**
 * The Translate class represents a command to translate figures in an SVG file.
 * It provides functionality to translate either all figures or a specific figure.
 */
public class Translate implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();
    private static StringBuilder translatedContent;
    private static Figure translatedFigure;
    private final FigureMapperString figureMapper = new FigureMapperString();

    /**
     * Helper method:
     * Translates all figures in the SVG file by the
     * specified vertical and horizontal distances.
     *
     * @param figures               List of strings representing SVG figures.
     * @param verticalTranslation   The vertical distance to translate.
     * @param horizontalTranslation The horizontal distance to translate.
     */
    private void translateAll(List<String> figures, int verticalTranslation, int horizontalTranslation) {
        String figure;

        for (String line : figures) {
            line = line.trim();
            figure = line.split(" ")[0];

            translatedFigure = this.figureMapper.figures.get(figure).apply(line);
            translatedContent.append(translatedFigure.translate(verticalTranslation, horizontalTranslation));
        }
        System.out.println("Successfully translated all figures!");
    }

    /**
     * * Helper method:
     * Translates a specific figure in the SVG file by the
     * specified vertical and horizontal distances.
     *
     * @param figures               List of strings representing SVG figures.
     * @param translateIndex        The index of the figure to translate.
     * @param verticalTranslation   The vertical distance to translate.
     * @param horizontalTranslation The horizontal distance to translate.
     */
    private void translateOne(List<String> figures, int translateIndex, int verticalTranslation, int horizontalTranslation) {
        String line;
        String figureType;

        if (translateIndex <= 0 || translateIndex > figures.size())
            System.out.println("There is no figure number " + translateIndex + "!");
        else
            System.out.println("Figure " + translateIndex + " translated successfully!");


        for (int i = 0; i < figures.size(); i++) {
            line = figures.get(i);

            if (i == translateIndex - 1) {
                line = line.trim();
                figureType = line.split(" ")[0];

                translatedFigure = this.figureMapper.figures.get(figureType).apply(line);
                translatedContent.append(translatedFigure.translate(verticalTranslation, horizontalTranslation));
            } else {
                translatedContent.append(line).append("\n");
            }
        }
    }

    /**
     * Executes the 'translate' command to
     * translate figures in the SVG file.
     *
     * @param args A List of String arguments. If three arguments are provided,
     *             it indicates translating a specific figure.
     *             Otherwise, it indicates translating all figures.
     */
    @Override
    public void execute(List<String> args) {
        if (fm.file == null) {
            System.out.println("No file is opened!");
            return;
        }

        if (args.isEmpty()) {
            System.out.println("To use 'translate' you must specify a horizontal and vertical translation, [Optional: id]!");
            return;
        }

        boolean translateOne = args.size() == 3;

        try {
            List<String> figures = fm.getFigures();

            translatedContent = new StringBuilder().append("<?xml version=\"1.0\" standalone=\"no\"?>").append("\n").append("<!DOCTYPE svg PUBLIC>").append("\n").append("<svg>").append("\n");

            if (translateOne)
                this.translateOne(figures, Integer.parseInt(args.getFirst()), Integer.parseInt(args.get(1).split("=")[1]), Integer.parseInt(args.get(2).split("=")[1]));
            else
                this.translateAll(figures, Integer.parseInt(args.getFirst().split("=")[1]), Integer.parseInt(args.get(1).split("=")[1]));


            translatedContent.append("</svg>");

            BufferedWriter writer = new BufferedWriter(new FileWriter(fm.file));
            writer.write(translatedContent.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        } catch (NumberFormatException e) {
            System.out.println("Translation properties must be numbers!");
        }
    }
}