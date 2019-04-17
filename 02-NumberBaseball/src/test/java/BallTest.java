import org.junit.Test;
import io.github.sogoagain.numberbaseball.model.Ball;

import static io.github.sogoagain.numberbaseball.model.Ball.MAXIMUM_OF_BALL;
import static io.github.sogoagain.numberbaseball.model.Ball.MINIMUN_OF_BALL;
import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFailWhenSmallerThanMin() throws Exception {
        createBall(MINIMUN_OF_BALL - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailWhenBiggerThanMax() throws Exception {
        createBall(MAXIMUM_OF_BALL + 1);
    }

    @Test
    public void testCreation() throws Exception {
        assertThat(createBall(MINIMUN_OF_BALL) == createBall(MINIMUN_OF_BALL)).isEqualTo(true);
        assertThat(createBall(MAXIMUM_OF_BALL) == createBall(MAXIMUM_OF_BALL)).isEqualTo(true);
    }

    public static Ball createBall(int number) {
        return Ball.of(number);
    }
}