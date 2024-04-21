package processors;

import java.util.ArrayList;
import java.util.List;

public class CircleProcessor extends FigureProcessor {
    @Override
    public List<String> getProperties(String figure) {
        List<String> properties = new ArrayList<>();
        properties.add(getValue(figure, "cx"));
        properties.add(getValue(figure, "cy"));
        properties.add(getValue(figure, "r"));
        properties.add(getValue(figure, "fill"));

        return properties;
    }

    @Override
    public String print(String figure) {
        List<String> properties = getProperties(figure);
        StringBuilder output = new StringBuilder().append("circle ");

        for (String property : properties) {
            output.append(property).append(" ");
        }

        return output.toString();
    }
}
