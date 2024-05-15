package interfaces;

import java.util.List;

/**
 * An interface for commands that require parameters for execution.
 */
public interface CommandWithParams {
    /**
     * Executes the command with the specified arguments.
     *
     * @param args A List of String arguments representing the parameters for the command.
     */
    void execute(List<String> args);
}
