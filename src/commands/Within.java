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

/**
 * The Within class represents a command to find
 * figures within a specified region in an SVG file.
 */
public class Within implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();
    private static final RectangleProcessor rp = new RectangleProcessor();
    private static final LineProcessor lp = new LineProcessor();
    private static final CircleProcessor cp = new CircleProcessor();

    /**
     * Executes the 'within' command to find figures
     * within a specified region in the SVG file.
     *
     * @param args A List of String arguments representing the region and its properties.
     *             The first argument should be the type of region (rectangle or circle).
     *             Subsequent arguments should be properties of the region.
     */
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
            String regionType = args.getFirst();
            int idx = 1;
            List<String> properties = args.subList(1, args.size());

            switch (regionType) {
                case "rectangle" -> region = new RectangleRegion(properties);
                case "circle" -> region = new CircleRegion(properties);
                default -> {
                    System.out.println("Invalid region type!");
                    return;
                }
            }

            for (String figure : fm.getFigures()) {
                figure = figure.trim();

                if (region.isWithin(figure)) {
                    switch (figure.trim().split(" ")[0]) {
                        case "<rect" -> toAppend = rp.print(figure);
                        case "<circle" -> toAppend = cp.print(figure);
                        default -> toAppend = lp.print(figure);
                    }

                    output.append(idx).append(". ").append(toAppend).append("\n");
                    idx++;
                }
            }

            if (!output.isEmpty())
                System.out.print(output);
            else
                System.out.println("No figures are located within " + regionType + " " + String.join(" ", properties) + "!");

        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            System.out.println("Invalid region properties!");
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}
