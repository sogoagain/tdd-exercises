package Lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    private int minimum_value = Ball.MINIMUM_VALUE;
    private int maximum_value = Ball.MAXIMUM_VALUE;

    @Test
    public void test_validNumber() throws Exception {
        Ball min = Ball.valueOf(minimum_value);
        Ball max = Ball.valueOf(maximum_value);

        assertThat(min).isExactlyInstanceOf(Ball.class);
        assertThat(max).isExactlyInstanceOf(Ball.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_invalidLeftNumber() throws Exception {
        Ball.valueOf(minimum_value - 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_invalidRightNumber() throws Exception {
        Ball.valueOf(maximum_value + 1);
    }

    @Test
    public void test_equals() throws Exception {
        Ball ball1 = Ball.valueOf(minimum_value);
        Ball ball2 = Ball.valueOf(maximum_value);

        boolean equalsResult = ball1.equals(ball2);
        boolean expectedResult = minimum_value == maximum_value;

        assertThat(equalsResult).isEqualTo(expectedResult);
    }

    @Test
    public void test_sort() throws Exception {
        Ball ball1 = Ball.valueOf(minimum_value);
        Ball ball2 = Ball.valueOf(maximum_value);

        int compareResult = ball1.compareTo(ball2);
        int expectedResult = Integer.compare(minimum_value, maximum_value);

        assertThat(compareResult).isEqualTo(expectedResult);
    }
}