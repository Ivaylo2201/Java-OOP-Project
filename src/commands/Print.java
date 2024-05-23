package commands;

import figures.Circle;
import interfaces.CommandWithoutParams;
import interfaces.Figure;
import figures.Line;
import figures.Rectangle;
import helpers.Extractor;
import managers.FileManager;
import processors.ProcessorsMap;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


/**
 * The Print class represents a command to print
 * all figures from the currently opened file.
 */
public class Print implements CommandWithoutParams {
    private static final FileManager fm = FileManager.getInstance();
    private final ProcessorsMap processorsMap = new ProcessorsMap();
    private final Extractor extractor = new Extractor();
    private final Map<String, Function<String, Figure>> figures = new HashMap<>();

    public Print() {
        this.figures.put("<rect", (line) -> new Rectangle(this.extractor.extract("rectangle", line)));
        this.figures.put("<circle", (line) -> new Circle(this.extractor.extract("circle", line)));
        this.figures.put("<line", (line) -> new Line(this.extractor.extract("line", line)));
    }

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
            String figureType;
            Figure figure;
            int idx = 1;

            for (String line : fm.getFigures()) {
                line = line.trim();
                figureType = line.split(" ")[0];
                figure = this.figures.get(figureType).apply(line);

                toAppend = this.processorsMap.processors.get(figure.getClass().getSimpleName().toLowerCase()).print(figure);
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
