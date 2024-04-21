package commands;

import contracts.CommandWithoutParams;
import managers.FileManager;

public class Close implements CommandWithoutParams {
    private static final FileManager fm = FileManager.getInstance();

    @Override
    public void execute() {
        if (fm.file == null) {
            System.out.println("No file is opened.");
            return;
        }

        System.out.println("Successfully closed " + fm.file.getName());
        fm.file = null;
    }
}
