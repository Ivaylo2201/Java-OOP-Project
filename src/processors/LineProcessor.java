package processors;

import java.util.ArrayList;
import java.util.List;

/**
 * The LineProcessor class processes line figures.
 */
public class LineProcessor extends FigureProcessor {
    /**
     * Retrieves the properties of a line figure.
     *
     * @param figure The string representation of the line figure.
     * @return A list of strings representing the properties of
     *        the line (x1, y1, x2, y2, stroke, stroke-width).
     */
    @Override
    public List<String> getProperties(String figure) {
        List<String> properties = new ArrayList<>();
        properties.add(getValue(figure, "x1"));
        properties.add(getValue(figure, "y1"));
        properties.add(getValue(figure, "x2"));
        properties.add(getValue(figure, "y2"));
        properties.add(getValue(figure, "stroke"));
        properties.add(getValue(figure, "stroke-width"));

        return properties;
    }

    /**
     * Generates a formatted string representation of the line figure.
     *
     * @param figure The string representation of the line figure.
     * @return A formatted string representing the line figure.
     */
    @Override
    public String print(String figure) {
        List<String> properties = getProperties(figure);
        StringBuilder output = new StringBuilder().append("line ");

        for (String property : properties) {
            output.append(property).append(" ");
        }

        return output.toString();
    }
}
