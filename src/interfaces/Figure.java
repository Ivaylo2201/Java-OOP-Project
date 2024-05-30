package interfaces;

/**
 * An interface for geometric figures.
 */
public interface Figure {
    /**
     * Translates the figure by the specified vertical and horizontal distances.
     *
     * @param vertical   The vertical distance to translate the figure.
     * @param horizontal The horizontal distance to translate the figure.
     * @return A String representation of the translated figure.
     */
    String translate(int vertical, int horizontal);
}
