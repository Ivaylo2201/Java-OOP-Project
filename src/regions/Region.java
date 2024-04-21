package regions;

import processors.CircleProcessor;
import processors.LineProcessor;
import processors.RectangleProcessor;

import java.util.List;

public abstract class Region {
    private static final RectangleProcessor rp = new RectangleProcessor();
    private static final LineProcessor lp = new LineProcessor();
    private static final CircleProcessor cp = new CircleProcessor();

    public boolean isWithin(String figure) {
        List<String> properties;

        if (figure.startsWith("<rect")) {
            properties = rp.getProperties(figure);
            int x = Integer.parseInt(properties.getFirst());
            int y = Integer.parseInt(properties.get(1));
            int width = Integer.parseInt(properties.get(2));
            int height = Integer.parseInt(properties.get(3));

            return this.checkRectangle(x, y, width, height);
        } else if (figure.startsWith("<circle")) {
            properties = cp.getProperties(figure);
            int cx = Integer.parseInt(properties.getFirst());
            int cy = Integer.parseInt(properties.get(1));
            int r = Integer.parseInt(properties.get(2));

            return this.checkCircle(cx, cy, r);
        } else {
            properties = lp.getProperties(figure);
            int x1 = Integer.parseInt(properties.getFirst());
            int y1 = Integer.parseInt(properties.get(1));
            int x2 = Integer.parseInt(properties.get(2));
            int y2 = Integer.parseInt(properties.get(3));

            return this.checkLine(x1, y1, x2, y2);
        }
    }

    public abstract boolean checkRectangle(double x, double y, double width, double height);

    public abstract boolean checkCircle(double cx, double cy, double r);

    public abstract boolean checkLine(double x1, double y1, double x2, double y2);
}
