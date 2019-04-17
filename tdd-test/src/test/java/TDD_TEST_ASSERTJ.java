import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TDD_TEST_ASSERTJ {
    @Test
    public void test_TDD_TEST_ASSERTJ() throws Exception {

        assertThat((new TDD()).getNumberOne()).isEqualTo(1);
        assertThat((new TDD()).getNumberOne()).isEqualTo(2);
    }
}