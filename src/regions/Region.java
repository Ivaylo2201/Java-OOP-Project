package regions;

import interfaces.Figure;
import helpers.ProcessorMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * The Region abstract class represents a region in a graphical context.
 */
public abstract class Region {
    private final Map<String, Function<Figure, List<String>>> propertiesMap = new HashMap<>();
    private final Map<String, Function<List<String>, Boolean>> result = new HashMap<>();
    private final ProcessorMapper processorsMapper = new ProcessorMapper();

    public Region() {
        this.propertiesMap.put("rectangle", (figure) -> this.processorsMapper.processors.get("rectangle").getProperties(figure));
        this.propertiesMap.put("circle", (figure) -> this.processorsMapper.processors.get("circle").getProperties(figure));
        this.propertiesMap.put("line", (figure) -> this.processorsMapper.processors.get("line").getProperties(figure));
        this.result.put("rectangle", (properties) -> this.checkRectangle(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2)), Integer.parseInt(properties.get(3))));
        this.result.put("circle", (properties) -> this.checkCircle(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2))));
        this.result.put("line", (properties) -> this.checkLine(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2)), Integer.parseInt(properties.get(3))));
    }

    /**
     * Checks if a figure is within the region.
     *
     * @param figure The string representation of the figure.
     * @return true if the figure is within the region, false otherwise.
     */
    public boolean isWithin(Figure figure) {
        String figureType = figure.getClass().getSimpleName().toLowerCase();
        List<String> figureProperties = this.propertiesMap.get(figureType).apply(figure);

        return result.get(figureType).apply(figureProperties);
    }

    public abstract boolean checkRectangle(double x, double y, double width, double height);

    public abstract boolean checkCircle(double cx, double cy, double r);

    public abstract boolean checkLine(double x1, double y1, double x2, double y2);
}
