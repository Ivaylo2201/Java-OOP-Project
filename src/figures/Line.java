package figures;

import interfaces.Figure;

import java.util.List;

/**
 * Represents a line figure in an SVG.
 */
public class Line implements Figure {
    private String x1;
    private String y1;
    private String x2;
    private String y2;
    private final String stroke;
    private final String strokeWidth;

    /**
     * Constructs a line with the specified properties.
     *
     * @param properties A List of String properties including x1, y1, x2, y2, stroke, and strokeWidth.
     */
    public Line(List<String> properties) {
        this.x1 = properties.get(0);
        this.y1 = properties.get(1);
        this.x2 = properties.get(2);
        this.y2 = properties.get(3);
        this.stroke = properties.get(4);
        this.strokeWidth = properties.get(5);
    }

    public String getX1() {
        return this.x1;
    }
    public String getY1() {
        return this.y1;
    }
    public String getX2() {
        return this.x2;
    }
    public String getY2() {
        return this.y2;
    }
    public String getStroke() {
        return this.stroke;
    }
    public String getStrokeWidth() {
        return this.strokeWidth;
    }

    /**
     * Returns the SVG representation of the line.
     *
     * @return The SVG representation of the line.
     */
    @Override
    public String toString() {
        return String.format("    <line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" stroke=\"%s\" stroke-width=\"%s\"/>\n", this.x1, this.y1, this.x2, this.y2, this.stroke, this.strokeWidth);
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
        this.x1 = Integer.toString(Integer.parseInt(this.x1) + horizontal);
        this.y1 = Integer.toString(Integer.parseInt(this.y1) + vertical);
        this.x2 = Integer.toString(Integer.parseInt(this.x2) + horizontal);
        this.y2 = Integer.toString(Integer.parseInt(this.y2) + vertical);
        return this.toString();
    }

    /**
     * Checks if the line has valid properties.
     *
     * @return true if the line has valid properties, otherwise false.
     */
    @Override
    public boolean isValid() {
        String regex = "-?\\d+(\\.\\d+)?";
        return this.x1.matches(regex) && this.y1.matches(regex) && this.x2.matches(regex) && this.y2.matches(regex) && this.strokeWidth.matches(regex);
    }
}
