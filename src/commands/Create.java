package commands;

import contracts.CommandWithParams;
import contracts.Figure;
import figures.Circle;
import figures.Rectangle;
import figures.Line;
import creators.FigureCreator;
import managers.FileManager;

import java.util.List;

public class Create implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();
    private static final FigureCreator figureCreator = new FigureCreator();

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

        String figureType = args.getFirst();
        List<String> properties = args.subList(1, args.size());
        Figure figure = null;

        try {
            figure = switch (figureType) {
                case "rectangle" -> new Rectangle(properties);
                case "circle" -> new Circle(properties);
                case "line" -> new Line(properties);
                default -> null;
            };
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid number of properties!");
        }

        if (figure == null) {
            System.out.println("Invalid figure type!");
            return;
        }

        if (figure.isValid()) {
            figureCreator.create(figure.toString());
            System.out.println("Successfully created " + figure.getClass().getSimpleName().toLowerCase());
        } else {
            System.out.println("Invalid figure properties!");
        }
    }
}
