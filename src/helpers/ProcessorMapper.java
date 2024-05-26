package helpers;

import interfaces.FigureProcessor;
import processors.CircleProcessor;
import processors.LineProcessor;
import processors.RectangleProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class for managing figure processors.
 */
public class ProcessorMapper {
    /**
     * A map of figure types to their corresponding processors.
     */
    public final Map<String, FigureProcessor> processors = new HashMap<>();

    /**
     * Constructs a new Processors instance and initializes processors for supported figure types.
     */
    public ProcessorMapper() {
        this.processors.put("rectangle", new RectangleProcessor());
        this.processors.put("circle", new CircleProcessor());
        this.processors.put("line", new LineProcessor());
    }
}
