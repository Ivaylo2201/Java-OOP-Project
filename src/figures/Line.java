package figures;

import contracts.Figure;

import java.util.List;

public class Line implements Figure {
    private String x1;
    private String y1;
    private String x2;
    private String y2;
    private final String stroke;
    private final String strokeWidth;

    public Line(List<String> properties) {
        this.x1 = properties.get(0);
        this.y1 = properties.get(1);
        this.x2 = properties.get(2);
        this.y2 = properties.get(3);
        this.stroke = properties.get(4);
        this.strokeWidth = properties.get(5);
    }

    @Override
    public String toString() {
        return String.format("    <line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" stroke=\"%s\" stroke-width=\"%s\"/>\n", this.x1, this.y1, this.x2, this.y2, this.stroke, this.strokeWidth);
    }

    @Override
    public String translate(int vertical, int horizontal) {
        this.x1 = Integer.toString(Integer.parseInt(this.x1) + horizontal);
        this.y1 = Integer.toString(Integer.parseInt(this.y1) + vertical);
        this.x2 = Integer.toString(Integer.parseInt(this.x2) + horizontal);
        this.y2 = Integer.toString(Integer.parseInt(this.y2) + vertical);
        return this.toString();
    }

    @Override
    public boolean isValid() {
        String regex = "-?\\d+(\\.\\d+)?";
        return this.x1.matches(regex) && this.y1.matches(regex) && this.x2.matches(regex) && this.y2.matches(regex) && this.strokeWidth.matches(regex);
    }
}
