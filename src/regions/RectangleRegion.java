package regions;

import java.util.List;

public class RectangleRegion extends Region {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public RectangleRegion(List<String> properties) {
        this.x = Integer.parseInt(properties.getFirst());
        this.y = Integer.parseInt(properties.get(1));
        this.width = Integer.parseInt(properties.get(2));
        this.height = Integer.parseInt(properties.get(3));
    }

    @Override
    public boolean checkRectangle(double x, double y, double width, double height) {
        return x >= this.x &&
            y >= this.y &&
            x + width <= this.x + this.width &&
            y + height <= this.y + this.height &&
            width <= this.width &&
            height <= this.height;
    }

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

    @Override
    public boolean checkLine(double x1, double y1, double x2, double y2) {
        return (x1 >= this.x && x1 <= this.x + this.width && y1 >= this.y && y1 <= this.y + this.height) &&
            (x2 >= this.x && x2 <= this.x + this.width && y2 >= this.y && y2 <= this.y + this.height);
    }
}
