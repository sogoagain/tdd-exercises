package Lotto.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ResultsTest {

    private Results results;

    @Before
    public void initResults() {
        results = new Results();
    }

    @Test
    public void test_statisticsTest() throws Exception {
        results.put(Rank.FIRST);
        results.put(Rank.FIRST);
        results.put(Rank.FOURTH);

        Map<Rank, Integer> resultMap = results.getStatistics();
        assertThat(resultMap.get(Rank.FIRST)).isEqualTo(2);
        assertThat(resultMap.get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_modifyTest() throws Exception {
        results.put(Rank.FIRST);
        results.put(Rank.FIRST);
        results.put(Rank.FOURTH);

        Map<Rank, Integer> resultMap = results.getStatistics();
        resultMap.putIfAbsent(Rank.ETC, 1);
    }
}