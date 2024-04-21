package figures;

import contracts.Figure;

import java.util.List;

public class Circle implements Figure {
    private String cx;
    private String cy;
    private final String r;
    private final String fill;

    public Circle(List<String> properties) {
        this.cx = properties.get(0);
        this.cy = properties.get(1);
        this.r = properties.get(2);
        this.fill = properties.get(3);
    }

    @Override
    public String toString() {
        return String.format("    <circle cx=\"%s\" cy=\"%s\" r=\"%s\" fill=\"%s\"/>\n", this.cx, this.cy, this.r, this.fill);
    }

    @Override
    public String translate(int vertical, int horizontal) {
        this.cx = Integer.toString(Integer.parseInt(this.cx) + horizontal);
        this.cy = Integer.toString(Integer.parseInt(this.cy) + vertical);
        return this.toString();
    }

    @Override
    public boolean isValid() {
        String regex = "-?\\d+(\\.\\d+)?";
        return this.cx.matches(regex) && this.cy.matches(regex) && this.r.matches(regex);
    }
}
