package contracts;

import java.util.List;

public interface Figure {
    String translate(int vertical, int horizontal);
    boolean isValid();
}
