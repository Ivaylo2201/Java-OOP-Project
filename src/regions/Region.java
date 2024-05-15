package regions;

import interfaces.Figure;
import processors.CircleProcessor;
import processors.LineProcessor;
import processors.RectangleProcessor;

import java.util.List;

/**
 * The Region abstract class represents a region in a graphical context.
 */
public abstract class Region {
    private static final RectangleProcessor rp = new RectangleProcessor();
    private static final LineProcessor lp = new LineProcessor();
    private static final CircleProcessor cp = new CircleProcessor();

    /**
     * Checks if a figure is within the region.
     *
     * @param figure The string representation of the figure.
     * @return true if the figure is within the region, false otherwise.
     */
    public boolean isWithin(Figure figure) {
        List<String> properties;

        switch (figure.getClass().getSimpleName().toLowerCase()) {
            case "rectangle" -> {
                properties = rp.getProperties(figure);
                return this.checkRectangle(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2)), Integer.parseInt(properties.get(3)));
            }
            case "circle" -> {
                properties = cp.getProperties(figure);
                return this.checkCircle(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2)));
            }
            default -> {
                properties = lp.getProperties(figure);
                return this.checkLine(Integer.parseInt(properties.getFirst()), Integer.parseInt(properties.get(1)), Integer.parseInt(properties.get(2)), Integer.parseInt(properties.get(3)));
            }
        }
    }

    public abstract boolean checkRectangle(double x, double y, double width, double height);

    public abstract boolean checkCircle(double cx, double cy, double r);

    public abstract boolean checkLine(double x1, double y1, double x2, double y2);
}
