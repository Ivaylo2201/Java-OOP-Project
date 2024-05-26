package commands;

import helpers.FigureMapperString;
import interfaces.CommandWithoutParams;
import interfaces.Figure;
import managers.FileManager;
import helpers.ProcessorMapper;
import java.io.IOException;


/**
 * The Print class represents a command to print
 * all figures from the currently opened file.
 */
public class Print implements CommandWithoutParams {
    private static final FileManager fm = FileManager.getInstance();
    private final ProcessorMapper processorsMapper = new ProcessorMapper();
    private final FigureMapperString figureMapper = new FigureMapperString();

    /**
     * Iterates over the figures in the opened
     * file and appends them to a StringBuilder
     * using the corresponding processor
     */
    @Override
    public void execute() {
        if (fm.file == null) {
            System.out.println("No file is opened!");
            return;
        }

        try {
            StringBuilder output = new StringBuilder();
            String toAppend;
            String figureType;
            Figure figure;
            int idx = 1;

            for (String line : fm.getFigures()) {
                line = line.trim();
                figureType = line.split(" ")[0];
                figure = this.figureMapper.figures.get(figureType).apply(line);

                toAppend = this.processorsMapper.processors.get(figure.getClass().getSimpleName().toLowerCase()).print(figure);
                output.append(idx).append(". ").append(toAppend).append("\n");
                idx++;
            }

            if (!output.isEmpty())
                System.out.print(output);
            else
                System.out.println("There are no figures in '" + fm.file.getName() + "'!");

        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}
