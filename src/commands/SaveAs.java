package commands;

import interfaces.CommandWithParams;
import managers.FileManager;

import java.io.*;
import java.util.List;

/**
 * The SaveAs class represents a command to save
 * the currently opened file with a new name.
 */
public class SaveAs implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();

    /**
     * Executes the 'saveas' command to save the currently opened file with a new name.
     *
     * @param args A List of String arguments. The first argument should be the new file name.
     *             If no arguments are provided, a message is printed indicating the required argument.
     *             If no file is currently opened, a message is printed indicating that no file is opened.
     */
    @Override
    public void execute(List<String> args) {
        if (fm.file == null) {
            System.out.println("No file is opened.");
            return;
        }

        if (args.isEmpty()) {
            System.out.println("To use 'saveas' you must specify the new file name!");
            return;
        }

        try {
            String fileName = args.getFirst();
            File savedFile = new File("src/" + fileName);

            FileReader reader = new FileReader(fm.file);
            FileWriter writer = new FileWriter(savedFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("Successfully saved as " + fileName);
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}