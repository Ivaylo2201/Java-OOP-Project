package commands;

import contracts.CommandWithParams;
import managers.FileManager;

import java.io.*;
import java.util.List;

public class SaveAs implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();

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