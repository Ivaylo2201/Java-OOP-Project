package interfaces;

import java.util.List;

/**
 * An interface for processing geometric figures.
 */
public interface FigureProcessor {
    /**
     * Retrieves the properties of a given figure.
     *
     * @param figure The figure to retrieve properties from.
     * @return A list of properties of the figure.
     */
    List<String> getProperties(Figure figure);

    /**
     * Generates a string representation of the given figure.
     *
     * @param figure The figure to print.
     * @return A string representation of the figure.
     */
    String print(Figure figure);
}
