package processors;

import java.util.ArrayList;
import java.util.List;

/**
 * The CircleProcessor class processes circle figures.
 */
public class CircleProcessor extends FigureProcessor {
    /**
     * Retrieves the properties of a circle figure.
     *
     * @param figure The string representation of the circle figure.
     * @return A list of strings representing the properties of the circle (cx, cy, r, fill).
     */
    @Override
    public List<String> getProperties(String figure) {
        List<String> properties = new ArrayList<>();
        properties.add(getValue(figure, "cx"));
        properties.add(getValue(figure, "cy"));
        properties.add(getValue(figure, "r"));
        properties.add(getValue(figure, "fill"));

        return properties;
    }

    /**
     * Generates a formatted string representation of the circle figure.
     *
     * @param figure The string representation of the circle figure.
     * @return A formatted string representing the circle figure.
     */
    @Override
    public String print(String figure) {
        List<String> properties = this.getProperties(figure);
        StringBuilder output = new StringBuilder().append("circle ");

        for (String property : properties) {
            output.append(property).append(" ");
        }

        return output.toString();
    }
}
