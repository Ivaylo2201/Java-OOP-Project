package commands;

import interfaces.CommandWithParams;
import interfaces.Figure;
import figures.Circle;
import figures.Line;
import figures.Rectangle;
import helpers.Extractor;
import processors.ProcessorsMap;
import regions.Region;
import managers.FileManager;
import regions.CircleRegion;
import regions.RectangleRegion;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;

/**
 * The Within class represents a command to find
 * figures within a specified region in an SVG file.
 */
public class Within implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();
    private final Extractor extractor = new Extractor();
    private final ProcessorsMap processors = new ProcessorsMap();
    private final Map<String, Function<String, Figure>> figures = new HashMap<>();
    private final Map<String, Function<List<String>, Region>> regions = new HashMap<>();

    public Within() {
        this.regions.put("circle", (line) -> new CircleRegion(line));
        this.regions.put("rectangle", (line) -> new RectangleRegion(line));
        this.figures.put("<rect", (line) -> new Rectangle(this.extractor.extract("rectangle", line)));
        this.figures.put("<circle", (line) -> new Circle(this.extractor.extract("circle", line)));
        this.figures.put("<line", (line) -> new Line(this.extractor.extract("line", line)));
    }

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
            String regionType = args.getFirst().toLowerCase();

            int idx = 1;

            List<String> properties = args.subList(1, args.size());

            if (this.regions.containsKey(regionType)) {
                region = this.regions.get(regionType).apply(properties);
            } else {
                System.out.println("Invalid region type!");
                return;
            }

            for (String line : fm.getFigures()) {
                line = line.trim();
                figure = this.figures.get(line.split(" ")[0]).apply(line);

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
