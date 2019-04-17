import io.github.sogoagain.numberbaseball.PitchingBallDigitsFactory;
import io.github.sogoagain.numberbaseball.PitchingBallFactory;
import io.github.sogoagain.numberbaseball.PitchingBallRandomFactory;
import io.github.sogoagain.numberbaseball.model.AnswerBall;
import io.github.sogoagain.numberbaseball.model.PitchingBall;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PitchingBallFactoryTest {
    @Test
    public void testSuccessWithRandomFactory() throws Exception {
        PitchingBall randomBall = PitchingBallFactory.getPitchingBall(new PitchingBallRandomFactory());
        assertThat(randomBall).isInstanceOf(PitchingBall.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailWhenNegativeDigits() throws Exception {
        PitchingBall digitsBall = PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(-123));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailWhenWrongLengthDigits() throws Exception {
        PitchingBall digitsBall = PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(1234));
    }
}