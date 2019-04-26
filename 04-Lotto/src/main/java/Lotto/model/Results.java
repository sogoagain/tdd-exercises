package Lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Results {

    private Map<Rank, Integer> results = new TreeMap<>(Comparator.naturalOrder());

    public void put(Rank rank) {
        results.putIfAbsent(rank, 0);
        results.computeIfPresent(rank, (k, v) -> ++v);
    }

    public Map<Rank, Integer> getStatistics() {
        return Collections.unmodifiableMap(results);
    }
}
