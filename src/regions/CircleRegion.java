package regions;

import java.util.List;

public class CircleRegion extends Region {
    private final int cx;
    private final int cy;
    private final int r;

    public CircleRegion(List<String> properties) {
        this.cx = Integer.parseInt(properties.getFirst());
        this.cy = Integer.parseInt(properties.get(1));
        this.r = Integer.parseInt(properties.get(2));
    }

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

    @Override
    public boolean checkCircle(double cx, double cy, double r) {
        return this.r > (Math.sqrt(Math.pow(cx - this.cx, 2) + Math.pow(cy - this.cy, 2)) + r);
    }

    @Override
    public boolean checkLine(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - this.cx, 2) + Math.pow(y1 - this.cy, 2)) < this.r &&
            Math.sqrt(Math.pow(x2 - this.cx, 2) + Math.pow(y2 - this.cy, 2)) < this.r;
    }
}
