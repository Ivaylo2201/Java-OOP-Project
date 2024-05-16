package processors;

import interfaces.FigureProcessor;

import java.util.HashMap;
import java.util.Map;

public class Processors {
    public final Map<String, FigureProcessor> processors = new HashMap<>();

    public Processors() {
        this.processors.put("rectangle", new RectangleProcessor());
        this.processors.put("circle", new CircleProcessor());
        this.processors.put("line", new LineProcessor());
    }
}
