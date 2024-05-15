package figures;

import interfaces.Figure;

import java.util.List;

/**
 * Represents a circle figure in an SVG.
 */
public class Circle implements Figure {
    private String cx;
    private String cy;
    private final String r;
    private final String fill;

    public String getCx() {
        return cx;
    }

    public String getCy() {
        return cy;
    }

    public String getR() {
        return r;
    }

    public String getFill() {
        return fill;
    }

    /**
     * Constructs a circle with the specified properties.
     *
     * @param properties A List of String properties including cx, cy, r, and fill.
     */
    public Circle(List<String> properties) {
        this.cx = properties.get(0);
        this.cy = properties.get(1);
        this.r = properties.get(2);
        this.fill = properties.get(3);
    }

    /**
     * Returns the SVG representation of the circle.
     *
     * @return The SVG representation of the circle.
     */
    @Override
    public String toString() {
        return String.format("    <circle cx=\"%s\" cy=\"%s\" r=\"%s\" fill=\"%s\"/>\n", this.cx, this.cy, this.r, this.fill);
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
        this.cx = Integer.toString(Integer.parseInt(this.cx) + horizontal);
        this.cy = Integer.toString(Integer.parseInt(this.cy) + vertical);
        return this.toString();
    }

    /**
     * Checks if the circle has valid properties.
     *
     * @return true if the circle has valid properties, otherwise false.
     */
    @Override
    public boolean isValid() {
        String regex = "-?\\d+(\\.\\d+)?";
        return this.cx.matches(regex) && this.cy.matches(regex) && this.r.matches(regex);
    }
}
