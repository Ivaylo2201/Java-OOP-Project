package helpers;

import exceptions.UnsupportedFigureTypeException;
import figures.Circle;
import figures.Line;
import figures.Rectangle;
import interfaces.Figure;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The FigureMapperString class maps string representations of figures to their corresponding figure objects.
 * It uses an Extractor to extract the necessary data from strings and creates the appropriate figure instances.
 */
public class FigureMapperString {
    public final Map<String, Function<String, Figure>> figures = new HashMap<>();
    private final Extractor extractor = new Extractor();

    /**
     * Constructs a new FigureMapperString and initializes the map with supported figure mappings.
     * The mappings are from specific string prefixes to functions that create figure instances.
     */
    public FigureMapperString() {
        this.figures.put("<rect", (line) -> new Rectangle(this.extractor.extract("rectangle", line)));
        this.figures.put("<circle", (line) -> new Circle(this.extractor.extract("circle", line)));
        this.figures.put("<line", (line) -> new Line(this.extractor.extract("line", line)));
    }

    public Figure getFigure(String figureType, String line) throws UnsupportedFigureTypeException {
        Function<String, Figure> figure = this.figures.get(figureType);

        if (figure != null)
            return figure.apply(line);
        else
            throw new UnsupportedFigureTypeException();
    }
}
