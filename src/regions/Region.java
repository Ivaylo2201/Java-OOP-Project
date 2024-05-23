package regions;

import interfaces.Figure;
import processors.ProcessorsMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * The Region abstract class represents a region in a graphical context.
 */
public abstract class Region {
    private final ProcessorsMap processorsMap = new ProcessorsMap();

    /**
     * Checks if a figure is within the region.
     *
     * @param figure The string representation of the figure.
     * @return true if the figure is within the region, false otherwise.
     */
    public boolean isWithin(Figure figure) {
        Map<String, Function<Void, List<String>>> propertiesMap = new HashMap<>();
        propertiesMap.put("rectangle", _ -> this.processorsMap.processors.get("rectangle").getProperties(figure));
        propertiesMap.put("circle", _ -> this.processorsMap.processors.get("circle").getProperties(figure));
        propertiesMap.put("line", _ -> this.processorsMap.processors.get("line").getProperties(figure));

        Map<String, Function<List<String>, Boolean>> result = new HashMap<>();
        result.put("rectangle", (properties) -> this.checkRectangle(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2)), Integer.parseInt(properties.get(3))));
        result.put("circle", (properties) -> this.checkCircle(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2))));
        result.put("line", (properties) -> this.checkLine(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2)), Integer.parseInt(properties.get(3))));

        String figureType = figure.getClass().getSimpleName().toLowerCase();
        List<String> figureProperties = propertiesMap.get(figureType).apply(null);

        return result.get(figureType).apply(figureProperties);
    }

    public abstract boolean checkRectangle(double x, double y, double width, double height);

    public abstract boolean checkCircle(double cx, double cy, double r);

    public abstract boolean checkLine(double x1, double y1, double x2, double y2);
}
