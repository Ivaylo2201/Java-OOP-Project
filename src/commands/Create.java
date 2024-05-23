package commands;

import interfaces.CommandWithParams;
import interfaces.Figure;
import figures.Circle;
import figures.Rectangle;
import figures.Line;
import creators.FigureCreator;
import managers.FileManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * The Create class represents a command to create a figure and add it to the current file.
 */
public class Create implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();
    private final FigureCreator figureCreator = new FigureCreator();

    /**
     * Creates a new figure instance based on user input
     * and appends in to the opened file if it is valid
     *
     * @param args A list of strings representing the command arguments.
     */
    @Override
    public void execute(List<String> args) {
        if (fm.file == null) {
            System.out.println("No file is opened.");
            return;
        }

        if (args.isEmpty()) {
            System.out.println("To use 'create' you must specify the figure type and its properties!");
            return;
        }

        List<String> properties = args.subList(1, args.size());

        Map<String, Function<Void, Figure>> figures = new HashMap<>();
        figures.put("rectangle", _ -> new Rectangle(properties));
        figures.put("circle", _ -> new Circle(properties));
        figures.put("line", _ -> new Line(properties));

        Figure figure;
        String figureType = args.getFirst().toLowerCase();

        try {
            if (figures.containsKey(figureType)) {
                figure = figures.get(figureType).apply(null);
            } else {
                System.out.println("Invalid figure type!");
                return;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid number of properties!");
            return;
        }

        if (figure.isValid()) {
            this.figureCreator.create(figure);
            System.out.println("Successfully created " + figure.getClass().getSimpleName().toLowerCase());
        } else {
            System.out.println("Invalid figure properties!");
        }
    }
}
