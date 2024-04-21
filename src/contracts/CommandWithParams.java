package contracts;

import java.util.List;

public interface CommandWithParams {
    void execute(List<String> args);
}
