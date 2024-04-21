package commands;

import contracts.CommandWithParams;
import regions.Region;
import managers.FileManager;
import processors.CircleProcessor;
import processors.LineProcessor;
import processors.RectangleProcessor;
import regions.CircleRegion;
import regions.RectangleRegion;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class Within implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();
    private static final RectangleProcessor rp = new RectangleProcessor();
    private static final LineProcessor lp = new LineProcessor();
    private static final CircleProcessor cp = new CircleProcessor();

    @Override
    public void execute(List<String> args) {
        Region region;

        if (fm.file == null) {
            System.out.println("No file is opened!");
            return;
        }

        if (args.isEmpty()) {
            System.out.println("Arguments were not provided!");
            return;
        }

        try {
            StringBuilder output = new StringBuilder();
            String toAppend;
            String figureType = args.getFirst();
            int idx = 1;
            List<String> properties = args.subList(1, args.size());

            if (figureType.equals("rectangle"))
                region = new RectangleRegion(properties);
            else if (figureType.equals("circle"))
                region = new CircleRegion(properties);
            else {
                System.out.println("Invalid region type!");
                return;
            }

            for (String figure : fm.getFigures()) {
                figure = figure.trim();

                if (region.isWithin(figure)) {
                    if (figure.startsWith("<rect"))
                        toAppend = rp.print(figure);
                    else if (figure.startsWith("<circle"))
                        toAppend = cp.print(figure);
                    else
                        toAppend = lp.print(figure);

                    output.append(idx).append(". ").append(toAppend).append("\n");
                    idx++;
                }
            }

            if (!output.isEmpty())
                System.out.print(output);
            else
                System.out.println("No figures are located within " + figureType + " " + String.join(" ", properties));

        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            System.out.println("Invalid region properties!");
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}
