package processors;

import interfaces.Figure;
import interfaces.FigureProcessor;
import figures.Circle;

import java.util.ArrayList;
import java.util.List;

/**
 * The CircleProcessor class processes circle figures.
 */
public class CircleProcessor implements FigureProcessor {
    /**
     * Retrieves the properties of a circle figure.
     *
     * @param figure The string representation of the circle figure.
     * @return A list of strings representing the properties of the circle (cx, cy, r, fill).
     */
    @Override
    public List<String> getProperties(Figure figure) {
        List<String> properties = new ArrayList<>();
        Circle circle = (Circle) figure;

        properties.add(circle.getCx());
        properties.add(circle.getCy());
        properties.add(circle.getR());
        properties.add(circle.getFill());

        return properties;
    }

    /**
     * Generates a formatted string representation of the circle figure.
     *
     * @param figure The string representation of the circle figure.
     * @return A formatted string representing the circle figure.
     */
    @Override
    public String print(Figure figure) {
        List<String> properties = this.getProperties(figure);
        StringBuilder output = new StringBuilder().append("circle ");

        for (String property : properties) {
            output.append(property).append(" ");
        }

        return output.toString();
    }
}
