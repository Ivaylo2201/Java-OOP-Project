package managers;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The FileManager class handles file
 * operations for reading figures from a file.
 */
public class FileManager {
    private static FileManager instance;
    public File file;

    private FileManager() {
    }

    /**
     * @return The singleton instance of FileManager.
     */
    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    /**
     * Reads the figures between the
     * svg tags in the file attribute
     *
     * @return A list of strings representing the figures.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public List<String> getFigures() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.file));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        reader.close();

        String xml = content.toString();
        int openingSvgTag = xml.indexOf("<svg>");
        int closingSvgTag = xml.indexOf("</svg>");
        String[] figuresArr = xml.substring(openingSvgTag + 5, closingSvgTag).split("\n");
        List<String> figures = new ArrayList<>(Arrays.asList(figuresArr));

        if (figures.isEmpty()) {
            return figures;
        }

        figures.removeFirst();

        return figures;
    }
}
