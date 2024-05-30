package commands;

import exceptions.InvalidAmountOfPropertiesException;
import exceptions.InvalidRegionPropertiesException;
import exceptions.UnsupportedProcessorTypeException;
import exceptions.UnsupportedRegionTypeException;
import helpers.FigureMapperString;
import helpers.RegionMapper;
import interfaces.CommandWithParams;
import interfaces.Figure;
import helpers.ProcessorMapper;
import regions.Region;
import managers.FileManager;
import java.io.IOException;
import java.util.*;


/**
 * The Within class represents a command to find
 * figures within a specified region in an SVG file.
 */
public class Within implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();
    private final ProcessorMapper processorMapper = new ProcessorMapper();
    private final FigureMapperString figureMapper = new FigureMapperString();
    private final RegionMapper regionMapper = new RegionMapper();

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

            region = this.regionMapper.getRegion(regionType, properties);

            for (String line : fm.getFigures()) {
                line = line.trim();
                figure = this.figureMapper.figures.get(line.split(" ")[0]).apply(line);

                if (region.isWithin(figure)) {
                    toAppend = this.processorMapper.getProcessor(figure.getClass().getSimpleName().toLowerCase()).print(figure);
                    output.append(idx).append(". ").append(toAppend).append("\n");
                    idx++;
                }
            }

            if (!output.isEmpty())
                System.out.print(output);
            else
                System.out.println("No figures are located within " + regionType + " " + String.join(" ", properties) + "!");

        } catch (UnsupportedProcessorTypeException e) {
            System.out.println("Unsupported processor type!");
        } catch (UnsupportedRegionTypeException e) {
            System.out.println("Unsupported region type!");
        } catch (InvalidAmountOfPropertiesException e) {
            System.out.println("Invalid amount of properties!");
        } catch (InvalidRegionPropertiesException e) {
            System.out.println("Invalid region properties!");
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}
