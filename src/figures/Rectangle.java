package figures;

import interfaces.Figure;

import java.util.List;

/**
 * Represents a rectangle figure in an SVG.
 */
public class Rectangle implements Figure {
    private String x;
    private String y;
    private final String width;
    private final String height;
    private final String fill;

    /**
     * Constructs a rectangle with the specified properties.
     *
     * @param properties A List of String properties including x, y, width, height, and fill.
     */
    public Rectangle(List<String> properties) {
        this.x = properties.get(0);
        this.y = properties.get(1);
        this.width = properties.get(2);
        this.height = properties.get(3);
        this.fill = properties.get(4);
    }

    public String getX() {
        return this.x;
    }
    public String getY() {
        return this.y;
    }
    public String getWidth() {
        return this.width;
    }
    public String getHeight() {
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
        return String.format("    <rect x=\"%s\" y=\"%s\" width=\"%s\" height=\"%s\" fill=\"%s\"/>\n", this.x, this.y, this.width, this.height, this.fill);
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
        this.x = Integer.toString(Integer.parseInt(this.x) + horizontal);
        this.y = Integer.toString(Integer.parseInt(this.y) + vertical);
        return this.toString();
    }

    /**
     * Checks if the rectangle has valid properties.
     *
     * @return true if the rectangle has valid properties, otherwise false.
     */
    @Override
    public boolean isValid() {
        String regex = "-?\\d+(\\.\\d+)?";
        return this.x.matches(regex) && this.y.matches(regex) && this.width.matches(regex) && this.height.matches(regex);
    }
}
