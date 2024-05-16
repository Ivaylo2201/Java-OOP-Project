package commands;

import figures.Circle;
import interfaces.CommandWithoutParams;
import interfaces.Figure;
import figures.Line;
import figures.Rectangle;
import helpers.Extractor;
import managers.FileManager;
import processors.Processors;
import java.io.IOException;


/**
 * The Print class represents a command to print
 * all figures from the currently opened file.
 */
public class Print implements CommandWithoutParams {
    private static final FileManager fm = FileManager.getInstance();
    private final Processors processors = new Processors();
    private final Extractor extractor = new Extractor();

    /**
     * Iterates over the figures in the opened
     * file and appends them to a StringBuilder
     * using the corresponding processor
     */
    @Override
    public void execute() {
        if (fm.file == null) {
            System.out.println("No file is opened.");
            return;
        }

        try {
            StringBuilder output = new StringBuilder();
            String toAppend;
            Figure figure;
            int idx = 1;

            for (String line : fm.getFigures()) {
                line = line.trim();

                switch (line.split(" ")[0]) {
                    case "<rect" -> figure = new Rectangle(this.extractor.extract("rectangle", line));
                    case "<circle" -> figure = new Circle(this.extractor.extract("circle", line));
                    default -> figure = new Line(this.extractor.extract("line", line));
                }

                toAppend = this.processors.processors.get(figure.getClass().getSimpleName().toLowerCase()).print(figure);
                output.append(idx).append(". ").append(toAppend).append("\n");
                idx++;
            }

            if (!output.isEmpty())
                System.out.print(output);
            else
                System.out.println("There are no figures in " + fm.file.getName());

        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}
