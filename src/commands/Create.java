package commands;

import exceptions.InvalidAmountOfPropertiesException;
import exceptions.InvalidFigurePropertiesException;
import exceptions.UnsupportedFigureTypeException;
import helpers.FigureMapperList;
import interfaces.CommandWithParams;
import interfaces.Figure;
import creators.FigureCreator;
import managers.FileManager;

import java.util.List;

/**
 * The Create class represents a command to create a figure and add it to the current file.
 */
public class Create implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();
    private final FigureCreator figureCreator = new FigureCreator();
    private final FigureMapperList figureMapper = new FigureMapperList();

    /**
     * Creates a new figure instance based on user input
     * and appends in to the opened file if it is valid
     *
     * @param args A list of strings representing the command arguments.
     */
    @Override
    public void execute(List<String> args) {
        if (fm.file == null) {
            System.out.println("No file is opened!");
            return;
        }

        if (args.isEmpty()) {
            System.out.println("To use 'create' you must specify the figure type and its properties!");
            return;
        }

        Figure figure;
        String figureType = args.getFirst().toLowerCase();
        List<String> properties = args.subList(1, args.size());

        try {
            figure = this.figureMapper.getFigure(figureType, properties);

            this.figureCreator.create(figure);
            System.out.println("Successfully created " + figure.getClass().getSimpleName().toLowerCase() + "!");

        } catch (InvalidFigurePropertiesException _) {
            System.out.println("Invalid figure properties!");
        } catch (InvalidAmountOfPropertiesException _) {
            System.out.println("Invalid amount of properties!");
        } catch (UnsupportedFigureTypeException _) {
            System.out.println("Invalid figure type!");
        }
    }
}
