package figures;

import contracts.Figure;

import java.util.List;

public class Rectangle implements Figure {
    private String x;
    private String y;
    private final String width;
    private final String height;
    private final String fill;

    public Rectangle(List<String> properties) {
        this.x = properties.get(0);
        this.y = properties.get(1);
        this.width = properties.get(2);
        this.height = properties.get(3);
        this.fill = properties.get(4);
    }

    @Override
    public String toString() {
        return String.format("    <rect x=\"%s\" y=\"%s\" width=\"%s\" height=\"%s\" fill=\"%s\"/>\n", this.x, this.y, this.width, this.height, this.fill);
    }

    @Override
    public String translate(int vertical, int horizontal) {
        this.x = Integer.toString(Integer.parseInt(this.x) + horizontal);
        this.y = Integer.toString(Integer.parseInt(this.y) + vertical);
        return this.toString();
    }

    @Override
    public boolean isValid() {
        String regex = "-?\\d+(\\.\\d+)?";
        return this.x.matches(regex) && this.y.matches(regex) && this.width.matches(regex) && this.height.matches(regex);
    }
}
