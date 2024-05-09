package regions;

import java.util.List;

/**
 * The RectangleRegion class represents a rectangular region.
 */
public class RectangleRegion extends Region {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    /**
     * Constructs a RectangleRegion with the specified properties.
     *
     * @param properties A list of strings representing the properties of the rectangle (x, y, width, height).
     */
    public RectangleRegion(List<String> properties) {
        this.x = Integer.parseInt(properties.getFirst());
        this.y = Integer.parseInt(properties.get(1));
        this.width = Integer.parseInt(properties.get(2));
        this.height = Integer.parseInt(properties.get(3));
    }

    /**
     * Checks if another rectangle is within the rectangular region.
     *
     * @param x      The x-coordinate of the top-left corner of the rectangle.
     * @param y      The y-coordinate of the top-left corner of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     * @return true if the rectangle is within the rectangular region, false otherwise.
     */
    @Override
    public boolean checkRectangle(double x, double y, double width, double height) {
        return x >= this.x &&
            y >= this.y &&
            x + width <= this.x + this.width &&
            y + height <= this.y + this.height &&
            width <= this.width &&
            height <= this.height;
    }

    /**
     * Checks if a circle is within the rectangular region.
     *
     * @param cx The x-coordinate of the center of the circle.
     * @param cy The y-coordinate of the center of the circle.
     * @param r  The radius of the circle.
     * @return true if the circle is within the rectangular region, false otherwise.
     */
    @Override
    public boolean checkCircle(double cx, double cy, double r) {
        return cx >= this.x &&
            cx <= this.x + this.width &&
            cy >= this.y &&
            cy <= this.y + this.height &&
            cx - r >= this.x &&
            cx + r <= this.x + this.width &&
            cy - r >= this.y &&
            cy + r <= this.y + this.height;
    }

    /**
     * Checks if a line is within the rectangular region.
     *
     * @param x1 The x-coordinate of the start point of the line.
     * @param y1 The y-coordinate of the start point of the line.
     * @param x2 The x-coordinate of the end point of the line.
     * @param y2 The y-coordinate of the end point of the line.
     * @return true if the line is within the rectangular region, false otherwise.
     */
    @Override
    public boolean checkLine(double x1, double y1, double x2, double y2) {
        return (x1 >= this.x && x1 <= this.x + this.width && y1 >= this.y && y1 <= this.y + this.height) &&
            (x2 >= this.x && x2 <= this.x + this.width && y2 >= this.y && y2 <= this.y + this.height);
    }
}
