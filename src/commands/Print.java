package commands;

import contracts.CommandWithoutParams;
import managers.FileManager;
import processors.CircleProcessor;
import processors.LineProcessor;
import processors.RectangleProcessor;

import java.io.IOException;

public class Print implements CommandWithoutParams {
    private static final FileManager fm = FileManager.getInstance();
    private static final RectangleProcessor rp = new RectangleProcessor();
    private static final CircleProcessor cp = new CircleProcessor();
    private static final LineProcessor lp = new LineProcessor();

    @Override
    public void execute() {
        if (fm.file == null) {
            System.out.println("No file is opened.");
            return;
        }

        try {
            StringBuilder output = new StringBuilder();
            String toAppend;
            int idx = 1;

            for (String figure : fm.getFigures()) {
                figure = figure.trim();

                switch (figure.split(" ")[0]) {
                    case "<rect" -> toAppend = rp.print(figure);
                    case "<circle" -> toAppend = cp.print(figure);
                    default -> toAppend = lp.print(figure);
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
