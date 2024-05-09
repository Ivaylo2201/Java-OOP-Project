package processors;

import java.util.ArrayList;
import java.util.List;

/**
 * The RectangleProcessor class processes rectangle figures.
 */
public class RectangleProcessor extends FigureProcessor {
    /**
     * Retrieves the properties of a rectangle figure.
     *
     * @param figure The string representation of the rectangle figure.
     * @return A list of strings representing the properties
     *        of the rectangle (x, y, width, height, fill).
     */
    @Override
    public List<String> getProperties(String figure) {
        List<String> properties = new ArrayList<>();
        properties.add(getValue(figure, "x"));
        properties.add(getValue(figure, "y"));
        properties.add(getValue(figure, "width"));
        properties.add(getValue(figure, "height"));
        properties.add(getValue(figure, "fill"));

        return properties;
    }

    /**
     * Generates a formatted string representation of the rectangle figure.
     *
     * @param figure The string representation of the rectangle figure.
     * @return A formatted string representing the rectangle figure.
     */
    @Override
    public String print(String figure) {
        List<String> properties = getProperties(figure);
        StringBuilder output = new StringBuilder().append("rectangle ");

        for (String property : properties) {
            output.append(property).append(" ");
        }

        return output.toString();
    }
}
