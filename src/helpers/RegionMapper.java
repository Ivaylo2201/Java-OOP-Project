package helpers;

import regions.CircleRegion;
import regions.RectangleRegion;
import regions.Region;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class RegionMapper {
    public final Map<String, Function<List<String>, Region>> regions = new HashMap<>();

    public RegionMapper() {
        this.regions.put("circle", (line) -> new CircleRegion(line));
        this.regions.put("rectangle", (line) -> new RectangleRegion(line));
    }
}
