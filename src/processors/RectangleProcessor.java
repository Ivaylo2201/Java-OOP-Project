package processors;

import java.util.ArrayList;
import java.util.List;

public class RectangleProcessor extends FigureProcessor {
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
