package commands;

import interfaces.CommandWithoutParams;
import managers.FileManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * The Save class represents a command
 * to save the currently opened file.
 */
public class Save implements CommandWithoutParams {
    private static final FileManager fm = FileManager.getInstance();

    /**
     * Copies the content of the file to a new
     * file, deletes the file and renames the new
     * file to the old one
     */
    @Override
    public void execute() {
        if (fm.file == null) {
            System.out.println("No file is opened!");
            return;
        }

        try {
            String currentFileName = fm.file.getName();
            String savedFileName = "src/temp.xml";
            File savedFile = new File(savedFileName);

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

            Path srcPath = savedFile.toPath();
            Path destPath = new File("src/" + currentFileName).toPath();
            Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);

            boolean isDeleted = savedFile.delete();

            if (!isDeleted) {
                System.out.println("An error has occurred while deleting the old file!");
            } else {
                System.out.println("Successfully saved the changes to '" + fm.file.getName() + "'!");
            }
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}