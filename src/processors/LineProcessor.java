package processors;

import java.util.ArrayList;
import java.util.List;

public class LineProcessor extends FigureProcessor {
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
