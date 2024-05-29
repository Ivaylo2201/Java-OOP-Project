package helpers;

import regions.CircleRegion;
import regions.RectangleRegion;
import regions.Region;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * The RegionMapper class maps string representations of regions to their corresponding region objects.
 * It uses a map to associate region types with functions that create the appropriate region instances from a list of strings.
 */
public class RegionMapper {
    public final Map<String, Function<List<String>, Region>> regions = new HashMap<>();

    /**
     * Constructs a new RegionMapper and initializes the map with supported region mappings.
     * The mappings are from specific region type strings to functions that create region instances.
     */
    public RegionMapper() {
        this.regions.put("circle", (line) -> new CircleRegion(line));
        this.regions.put("rectangle", (line) -> new RectangleRegion(line));
    }
}
