package interfaces;

import java.util.List;

/**
 * The FigureProcessor class serves as a
 * base class for processing various types of figures.
 */
public interface FigureProcessor {
    List<String> getProperties(Figure figure);
    String print(Figure figure);
}
