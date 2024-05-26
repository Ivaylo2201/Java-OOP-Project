package helpers;

import figures.Circle;
import figures.Line;
import figures.Rectangle;
import interfaces.Figure;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureMapperString {
    public final Map<String, Function<String, Figure>> figures = new HashMap<>();
    private final Extractor extractor = new Extractor();

    public FigureMapperString() {
        this.figures.put("<rect", (line) -> new Rectangle(this.extractor.extract("rectangle", line)));
        this.figures.put("<circle", (line) -> new Circle(this.extractor.extract("circle", line)));
        this.figures.put("<line", (line) -> new Line(this.extractor.extract("line", line)));
    }
}
