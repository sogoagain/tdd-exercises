import io.github.sogoagain.numberbaseball.model.Ball;
import io.github.sogoagain.numberbaseball.model.PitchingBall;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PitchingBallTest {
    @Test(expected = IllegalArgumentException.class)
    public void testFailWhenDuplicateValue() throws Exception {
        List<Ball> balls = new ArrayList<>();
        balls.add(Ball.of(Ball.MINIMUN_OF_BALL));
        balls.add(Ball.of(Ball.MINIMUN_OF_BALL));
        balls.add(Ball.of(Ball.MAXIMUM_OF_BALL));

        createPitchingBall(balls);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailWhenCountExceeded() throws Exception {
        List<Ball> balls = new ArrayList<>();
        balls.add(Ball.of(Ball.MINIMUN_OF_BALL));
        balls.add(Ball.of(Ball.MINIMUN_OF_BALL + 1));
        balls.add(Ball.of(Ball.MINIMUN_OF_BALL + 2));
        balls.add(Ball.of(Ball.MAXIMUM_OF_BALL));

        createPitchingBall(balls);

    }

    public PitchingBall createPitchingBall(List<Ball> balls) {
        return new PitchingBall(balls);
    }
}