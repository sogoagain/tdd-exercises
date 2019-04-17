import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoAnalyzerTest {
    @Test
    public void test_LottoAnalyzerTest() throws Exception {
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(100);
        lottoAnalyzer.simulate();
        assertThat(lottoAnalyzer.toString()).containsSequence("1등", ":")
                                            .containsSequence(" 2등", ":")
                                            .containsSequence(" 3등", ":")
                                            .containsSequence(" 4등", ":")
                                            .containsSequence(" 5등", ":");
    }
}