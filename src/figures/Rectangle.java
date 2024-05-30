package figures;

import exceptions.InvalidAmountOfPropertiesException;
import exceptions.InvalidFigurePropertiesException;
import interfaces.Figure;

import java.util.List;

/**
 * Represents a rectangle figure in an SVG.
 */
public class Rectangle implements Figure {
    private int x;
    private int y;
    private final int width;
    private final int height;
    private final String fill;

    /**
     * Constructs a rectangle with the specified properties.
     *
     * @param properties A List of String properties including x, y, width, height, and fill.
     */
    public Rectangle(List<String> properties) throws InvalidFigurePropertiesException, InvalidAmountOfPropertiesException {
        try {
            this.x = Integer.parseInt(properties.get(0));
            this.y = Integer.parseInt(properties.get(1));
            this.width = Integer.parseInt(properties.get(2));
            this.height = Integer.parseInt(properties.get(3));
            this.fill = properties.get(4);
        } catch (NumberFormatException _) {
            throw new InvalidFigurePropertiesException();
        } catch (IndexOutOfBoundsException _) {
            throw new InvalidAmountOfPropertiesException();
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getFill() {
        return this.fill;
    }

    /**
     * Returns the SVG representation of the rectangle.
     *
     * @return The SVG representation of the rectangle.
     */
    @Override
    public String toString() {
        return String.format("    <rect x=\"%s\" y=\"%s\" width=\"%s\" height=\"%s\" fill=\"%s\"/>\n", this.x, this.y, this.width, this.height, this.fill.toLowerCase());
    }

    /**
     * Translates the rectangle by the specified vertical and horizontal distances.
     *
     * @param vertical   The vertical distance to translate the rectangle.
     * @param horizontal The horizontal distance to translate the rectangle.
     * @return The SVG representation of the translated rectangle.
     */
    @Override
    public String translate(int vertical, int horizontal) {
        this.x += horizontal;
        this.y += vertical;
        return this.toString();
    }
}
