package processors;

import java.util.List;

public abstract class FigureProcessor {
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
