package processors;

import interfaces.Figure;
import interfaces.FigureProcessor;
import figures.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * The LineProcessor class processes line figures.
 */
public class LineProcessor implements FigureProcessor {
    /**
     * Retrieves the properties of a line figure.
     *
     * @param figure The figure object
     * @return A list of strings representing the properties of
     *        the line (x1, y1, x2, y2, stroke, stroke-width).
     */
    @Override
    public List<String> getProperties(Figure figure) {
        List<String> properties = new ArrayList<>();
        Line line = (Line) figure;

        properties.add(Integer.toString(line.getX1()));
        properties.add(Integer.toString(line.getY1()));
        properties.add(Integer.toString(line.getX2()));
        properties.add(Integer.toString(line.getY2()));
        properties.add(line.getStroke());
        properties.add(Integer.toString(line.getStrokeWidth()));

        return properties;
    }

    /**
     * Generates a formatted string representation of the line figure.
     *
     * @param figure The string representation of the line figure.
     * @return A formatted string representing the line figure.
     */
    @Override
    public String print(Figure figure) {
        List<String> properties = getProperties(figure);
        StringBuilder output = new StringBuilder().append("line ");

        for (String property : properties) {
            output.append(property).append(" ");
        }

        return output.toString();
    }
}
