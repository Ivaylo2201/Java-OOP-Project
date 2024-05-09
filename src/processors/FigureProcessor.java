package processors;

import java.util.List;

/**
 * The FigureProcessor class serves as a
 * base class for processing various types of figures.
 */
public abstract class FigureProcessor {
    /**
     * Retrieves the value of a specified property from the figure representation string.
     *
     * @param figure   The string representation of the figure.
     * @param property The property whose value is to be retrieved.
     * @return The value of the specified property, or null if the property is not found.
     */
    protected static String getValue(String figure, String property) {
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

    public abstract List<String> getProperties(String line);

    public abstract String print(String line);
}
