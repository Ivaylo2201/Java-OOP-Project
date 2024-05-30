package regions;

import exceptions.InvalidAmountOfPropertiesException;
import exceptions.InvalidRegionPropertiesException;

import java.util.List;

/**
 * The CircleRegion class represents a circular region.
 */
public class CircleRegion extends Region {
    private final int cx;
    private final int cy;
    private final int r;

    /**
     * Constructs a CircleRegion with the specified properties.
     *
     * @param properties A list of strings representing the properties of the circle (cx, cy, r).
     */
    public CircleRegion(List<String> properties) {
        try {
            this.cx = Integer.parseInt(properties.getFirst());
            this.cy = Integer.parseInt(properties.get(1));
            this.r = Integer.parseInt(properties.get(2));
        } catch (NumberFormatException _) {
            throw new InvalidRegionPropertiesException();
        } catch (IndexOutOfBoundsException _) {
            throw new InvalidAmountOfPropertiesException();
        }
    }

    /**
     * Checks if a rectangle is within the circular region.
     *
     * @param x      The x-coordinate of the top-left corner of the rectangle.
     * @param y      The y-coordinate of the top-left corner of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     * @return true if the rectangle is within the circular region, false otherwise.
     */
    @Override
    public boolean checkRectangle(double x, double y, double width, double height) {
        double distance1 = Math.sqrt(Math.pow(x - this.cx, 2) + Math.pow(y - this.cy, 2));
        double distance2 = Math.sqrt(Math.pow(x + width - this.cx, 2) + Math.pow(y - this.cy, 2));
        double distance3 = Math.sqrt(Math.pow(x + width - this.cx, 2) + Math.pow(y + height - this.cy, 2));
        double distance4 = Math.sqrt(Math.pow(x - this.cx, 2) + Math.pow(y + height - this.cy, 2));

        return distance1 < this.r &&
                distance2 < this.r &&
                distance3 < this.r &&
                distance4 < this.r;
    }

    /**
     * Checks if another circle is within the circular region.
     *
     * @param cx The x-coordinate of the center of the circle.
     * @param cy The y-coordinate of the center of the circle.
     * @param r  The radius of the circle.
     * @return true if the circle is within the circular region, false otherwise.
     */
    @Override
    public boolean checkCircle(double cx, double cy, double r) {
        return this.r > (Math.sqrt(Math.pow(cx - this.cx, 2) + Math.pow(cy - this.cy, 2)) + r);
    }

    /**
     * Checks if a line is within the circular region.
     *
     * @param x1 The x-coordinate of the start point of the line.
     * @param y1 The y-coordinate of the start point of the line.
     * @param x2 The x-coordinate of the end point of the line.
     * @param y2 The y-coordinate of the end point of the line.
     * @return true if the line is within the circular region, false otherwise.
     */
    @Override
    public boolean checkLine(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - this.cx, 2) + Math.pow(y1 - this.cy, 2)) < this.r &&
                Math.sqrt(Math.pow(x2 - this.cx, 2) + Math.pow(y2 - this.cy, 2)) < this.r;
    }
}
