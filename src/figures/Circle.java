package figures;

import exceptions.InvalidAmountOfPropertiesException;
import exceptions.InvalidFigurePropertiesException;
import interfaces.Figure;

import java.util.List;

/**
 * Represents a circle figure in an SVG.
 */
public class Circle implements Figure {
    private int cx;
    private int cy;
    private final int r;
    private final String fill;

    /**
     * Constructs a circle with the specified properties.
     *
     * @param properties A List of String properties including cx, cy, r, and fill.
     */
    public Circle(List<String> properties) throws InvalidFigurePropertiesException, InvalidAmountOfPropertiesException {
        try {
            this.cx = Integer.parseInt(properties.get(0));
            this.cy = Integer.parseInt(properties.get(1));
            this.r = Integer.parseInt(properties.get(2));
            this.fill = properties.get(3);
        } catch (NumberFormatException _) {
            throw new InvalidFigurePropertiesException();
        } catch (IndexOutOfBoundsException _) {
            throw new InvalidAmountOfPropertiesException();
        }
    }

    public int getCx() {
        return this.cx;
    }

    public int getCy() {
        return this.cy;
    }

    public int getR() {
        return this.r;
    }

    public String getFill() {
        return this.fill;
    }

    /**
     * Returns the SVG representation of the circle.
     *
     * @return The SVG representation of the circle.
     */
    @Override
    public String toString() {
        return String.format("    <circle cx=\"%s\" cy=\"%s\" r=\"%s\" fill=\"%s\"/>\n", this.cx, this.cy, this.r, this.fill.toLowerCase());
    }

    /**
     * Translates the circle by the specified vertical and horizontal distances.
     *
     * @param vertical   The vertical distance to translate the circle.
     * @param horizontal The horizontal distance to translate the circle.
     * @return The SVG representation of the translated circle.
     */
    @Override
    public String translate(int vertical, int horizontal) {
        this.cx += horizontal;
        this.cy += vertical;
        return this.toString();
    }
}
