package helpers;

import figures.Circle;
import figures.Line;
import figures.Rectangle;
import interfaces.Figure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureMapperList {
    public Map<String, Function<List<String>, Figure>> figures = new HashMap<>();

    public FigureMapperList() {
        figures.put("rectangle", (properties) -> new Rectangle(properties));
        figures.put("circle", (properties) -> new Circle(properties));
        figures.put("line", (properties) -> new Line(properties));
    }
}
