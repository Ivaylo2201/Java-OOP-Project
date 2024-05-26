package commands;

import interfaces.CommandWithParams;
import managers.FileManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The Open class represents
 * a command to open a file.
 */
public class Open implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();

    /**
     * Prefills the given file with initial SVG content.
     * @param file The file to prefill.
     */
    private void prefill(File file) {
        try {
            String fill = """
                <?xml version="1.0" standalone="no"?>
                <!DOCTYPE svg PUBLIC>
                <svg>
                </svg>""";

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(fill);
            writer.close();

        } catch (IOException e) {
            System.out.println("An error has occurred while prefilling the file!");
        }
    }

    /**
     * Checks if a directory exists. If it does open the file,
     * otherwise create it and then open it
     * @param args A list of strings representing the command arguments.
     */
    @Override
    public void execute(List<String> args) {
        if (args.isEmpty()) {
            System.out.println("To use 'open' you must specify a directory!");
            return;
        }

        try {
            String filePath = args.getFirst();
            File fileToOpen = new File(filePath);

            if (!fileToOpen.exists()) {
                if (fileToOpen.createNewFile()) {
                    System.out.println("Creating new file... ");
                    this.prefill(fileToOpen);
                } else {
                    System.out.println("An error has occurred while creating new file... ");
                    return;
                }
            }

            fm.file = fileToOpen;
            System.out.println("Successfully opened " + fm.file.getName() + "!");

        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}
