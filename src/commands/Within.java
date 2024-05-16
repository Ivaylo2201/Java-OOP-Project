package commands;

import interfaces.CommandWithParams;
import interfaces.Figure;
import figures.Circle;
import figures.Line;
import figures.Rectangle;
import helpers.Extractor;
import processors.Processors;
import regions.Region;
import managers.FileManager;
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
    private final Extractor extractor = new Extractor();
    private final Processors processors = new Processors();

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
        Figure figure;

        if (fm.file == null) {
            System.out.println("No file is opened!");
            return;
        }

        if (args.isEmpty()) {
            System.out.println("To use 'within' you must specify a region and its properties!");
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

            for (String line : fm.getFigures()) {
                line = line.trim();

                switch (line.split(" ")[0]) {
                    case "<rect" -> figure = new Rectangle(this.extractor.extract("rectangle", line));
                    case "<circle" -> figure = new Circle(this.extractor.extract("circle", line));
                    default -> figure = new Line(this.extractor.extract("line", line));
                }

                if (region.isWithin(figure)) {
                    toAppend = this.processors.processors.get(figure.getClass().getSimpleName().toLowerCase()).print(figure);
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
