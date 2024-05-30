package helpers;

import exceptions.UnsupportedFigureTypeException;
import figures.Circle;
import figures.Line;
import figures.Rectangle;
import interfaces.Figure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * The FigureMapperList class maps string representations of figure types to their corresponding figure objects.
 * It uses a map to associate figure types with functions that create the appropriate figure instances from a list of strings.
 */
public class FigureMapperList {
    public Map<String, Function<List<String>, Figure>> figures = new HashMap<>();

    /**
     * Constructs a new FigureMapperList and initializes the map with supported figure mappings.
     * The mappings are from specific figure type strings to functions that create figure instances.
     */
    public FigureMapperList() {
        figures.put("rectangle", (properties) -> new Rectangle(properties));
        figures.put("circle", (properties) -> new Circle(properties));
        figures.put("line", (properties) -> new Line(properties));
    }

    public Figure getFigure(String figureType, List<String> properties) throws UnsupportedFigureTypeException {
        Function<List<String>, Figure> figure = this.figures.get(figureType);

        if (figure != null) {
            return figure.apply(properties);
        } else
            throw new UnsupportedFigureTypeException();
    }
}
