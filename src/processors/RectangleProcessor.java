package processors;

import interfaces.Figure;
import interfaces.FigureProcessor;
import figures.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * The RectangleProcessor class processes rectangle figures.
 */
public class RectangleProcessor implements FigureProcessor {
    /**
     * Retrieves the properties of a rectangle figure.
     *
     * @param figure The string representation of the rectangle figure.
     * @return A list of strings representing the properties
     *        of the rectangle (x, y, width, height, fill).
     */
    @Override
    public List<String> getProperties(Figure figure) {
        List<String> properties = new ArrayList<>();
        Rectangle rectangle = (Rectangle) figure;

        properties.add(rectangle.getX());
        properties.add(rectangle.getY());
        properties.add(rectangle.getWidth());
        properties.add(rectangle.getHeight());
        properties.add(rectangle.getFill());

        return properties;
    }

    /**
     * Generates a formatted string representation of the rectangle figure.
     *
     * @param figure The string representation of the rectangle figure.
     * @return A formatted string representing the rectangle figure.
     */
    @Override
    public String print(Figure figure) {
        List<String> properties = getProperties(figure);
        StringBuilder output = new StringBuilder().append("rectangle ");

        for (String property : properties) {
            output.append(property).append(" ");
        }

        return output.toString();
    }
}
