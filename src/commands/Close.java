package commands;

import interfaces.CommandWithoutParams;
import managers.FileManager;

/**
 * The Close class represents a command to close the currently opened file.
 */
public class Close implements CommandWithoutParams {
    private static final FileManager fm = FileManager.getInstance();

    /**
     * Executes the close command.
     * If no file is opened, it prints a message indicating that no file is opened.
     * Otherwise, it prints a message indicating successful closure of the file.
     */
    @Override
    public void execute() {
        if (fm.file == null) {
            System.out.println("No file is opened!");
            return;
        }

        System.out.println("Successfully closed '" + fm.file.getName() + "'!");
        fm.file = null;
    }
}
