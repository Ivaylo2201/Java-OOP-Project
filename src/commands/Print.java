package commands;

import figures.Circle;
import interfaces.CommandWithoutParams;
import interfaces.Figure;
import figures.Line;
import figures.Rectangle;
import helpers.Extractor;
import managers.FileManager;
import processors.CircleProcessor;
import interfaces.FigureProcessor;
import processors.LineProcessor;
import processors.RectangleProcessor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The Print class represents a command to print
 * all figures from the currently opened file.
 */
public class Print implements CommandWithoutParams {
    private static final FileManager fm = FileManager.getInstance();
    private final Map<String, FigureProcessor> processors = new HashMap<>();
    private final Extractor extractor = new Extractor();

    public Print() {
        this.processors.put("rectangle", new RectangleProcessor());
        this.processors.put("circle", new CircleProcessor());
        this.processors.put("line", new LineProcessor());
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
            Figure figure;
            int idx = 1;

            for (String line : fm.getFigures()) {
                line = line.trim();

                switch (line.split(" ")[0]) {
                    case "<rect" -> {
                        figure = new Rectangle(this.extractor.extract("rectangle", line));
                        toAppend = this.processors.get("rectangle").print(figure);
                    }
                    case "<circle" -> {
                        figure = new Circle(this.extractor.extract("circle", line));
                        toAppend = this.processors.get("circle").print(figure);
                    }
                    default -> {
                        figure = new Line(this.extractor.extract("line", line));
                        toAppend = this.processors.get("line").print(figure);
                    }
                }

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
