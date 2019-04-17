package Lotto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class BallsTest {

    private Set<Ball> ballSet = new HashSet<>();

    @Before
    public void init() {
        initBallSet(ballSet);
    }

    private void initBallSet(Set<Ball> ballSet) {
        for (int i = 1; i <= Balls.SIZE; i++) {
            Ball ball = Ball.valueOf(i);
            ballSet.add(ball);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_overSizeNumbers() throws Exception {
        int maximum_value = Ball.MAXIMUM_VALUE;
        Ball newBall = Ball.valueOf(maximum_value);
        ballSet.add(newBall);

        Balls balls = new Balls(ballSet);
    }

    @Test
    public void test_equals() throws Exception {
        Set<Ball> otherBallSet = new HashSet<>();
        initBallSet(otherBallSet);

        Balls balls = new Balls(ballSet);
        Balls otherBalls = new Balls(otherBallSet);

        boolean result = balls.equals(otherBalls);
        assertThat(result).isEqualTo(true);
    }
}