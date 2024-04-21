package commands;

import contracts.CommandWithParams;
import managers.FileManager;

import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;

public class Erase implements CommandWithParams {
    private static final FileManager fm = FileManager.getInstance();

    @Override
    public void execute(List<String> args) {
        if (fm.file == null) {
            System.out.println("No file is opened.");
            return;
        }

        if (args.isEmpty()) {
            System.out.println("To use 'erase' you must specify figure id!");
            return;
        }

        try {
            int deleteIndex = Integer.parseInt(args.getFirst());

            List<String> figures = fm.getFigures();

            if (deleteIndex <= 0 || deleteIndex > figures.size()) {
                System.out.println("There is no figure number " + deleteIndex + "!");
            } else {
                System.out.println("Figure " + deleteIndex + " erased successfully!");
            }

            StringBuilder updatedContent = new StringBuilder().append("<?xml version=\"1.0\" standalone=\"no\"?>").append("\n").append("<!DOCTYPE svg PUBLIC>").append("\n").append("<svg>").append("\n");

            for (int i = 0; i < figures.size(); i++) {
                if (i != deleteIndex - 1) {
                    updatedContent.append(figures.get(i)).append("\n");
                }
            }

            updatedContent.append("</svg>");

            BufferedWriter writer = new BufferedWriter(new FileWriter(fm.file));
            writer.write(updatedContent.toString());
            writer.close();

        } catch (NoSuchElementException | ArrayIndexOutOfBoundsException e) {
            System.out.println("There are no figures in " + fm.file.getName());
        } catch (IOException e) {
            System.out.println("An error has occurred!");
        }
    }
}
