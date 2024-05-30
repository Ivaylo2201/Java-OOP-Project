package figures;

import exceptions.InvalidAmountOfPropertiesException;
import exceptions.InvalidFigurePropertiesException;
import interfaces.Figure;

import java.util.List;

/**
 * Represents a line figure in an SVG.
 */
public class Line implements Figure {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private final String stroke;
    private final int strokeWidth;

    /**
     * Constructs a line with the specified properties.
     *
     * @param properties A List of String properties including x1, y1, x2, y2, stroke, and strokeWidth.
     */
    public Line(List<String> properties) throws InvalidFigurePropertiesException, InvalidAmountOfPropertiesException {
        try {
            this.x1 = Integer.parseInt(properties.get(0));
            this.y1 = Integer.parseInt(properties.get(1));
            this.x2 = Integer.parseInt(properties.get(2));
            this.y2 = Integer.parseInt(properties.get(3));
            this.stroke = properties.get(4);
            this.strokeWidth = Integer.parseInt(properties.get(5));
        } catch (NumberFormatException _) {
            throw new InvalidFigurePropertiesException();
        } catch (IndexOutOfBoundsException _) {
            throw new InvalidAmountOfPropertiesException();
        }
    }

    public int getX1() {
        return this.x1;
    }

    public int getY1() {
        return this.y1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY2() {
        return this.y2;
    }

    public String getStroke() {
        return this.stroke;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    /**
     * Returns the SVG representation of the line.
     *
     * @return The SVG representation of the line.
     */
    @Override
    public String toString() {
        return String.format("    <line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" stroke=\"%s\" stroke-width=\"%s\"/>\n", this.x1, this.y1, this.x2, this.y2, this.stroke.toLowerCase(), this.strokeWidth);
    }

    /**
     * Translates the line by the specified vertical and horizontal distances.
     *
     * @param vertical   The vertical distance to translate the line.
     * @param horizontal The horizontal distance to translate the line.
     * @return The SVG representation of the translated line.
     */
    @Override
    public String translate(int vertical, int horizontal) {
        this.x1 += horizontal;
        this.y1 += vertical;
        this.x2 += horizontal;
        this.y2 += vertical;
        return this.toString();
    }
}
