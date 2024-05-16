package helpers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A utility class for extracting properties from figure descriptions.
 */
public class Extractor {
    /**
     * Retrieves the value of a specific property from a figure description.
     *
     * @param figure   The figure description.
     * @param property The property to extract.
     * @return The value of the property, or null if the property is not found.
     */
    public String get(String figure, String property) {
        String propertyStart = property + "=\"";
        int startIndex = figure.indexOf(propertyStart);
        if (startIndex == -1) {
            return null;
        }
        startIndex += propertyStart.length();
        int endIndex = figure.indexOf("\"", startIndex);
        if (endIndex == -1) {
            return null;
        }
        return figure.substring(startIndex, endIndex);
    }

    /**
     * Extracts a list of properties from a figure description based on the figure type.
     *
     * @param figure The type of figure ("rectangle", "circle", or "line").
     * @param line   The description of the figure.
     * @return A list of extracted properties.
     */
    public List<String> extract(String figure, String line) {
        List<String> extracted = new ArrayList<>();
        List<String> properties;

        switch (figure) {
            case "rectangle" -> properties = new ArrayList<>(Arrays.asList("x", "y", "width", "height", "fill"));
            case "circle" -> properties = new ArrayList<>(Arrays.asList("x", "y", "r", "fill"));
            case "line" -> properties = new ArrayList<>(Arrays.asList("x1", "y1", "x2", "y2", "stroke", "stroke-width"));
            default -> properties = new ArrayList<>();
        }

        for (String property : properties) {
            extracted.add(this.get(line, property));
        }

        return extracted;
    }
}
