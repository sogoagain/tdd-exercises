import io.github.sogoagain.numberbaseball.PitchingBallDigitsFactory;
import io.github.sogoagain.numberbaseball.PitchingBallFactory;
import io.github.sogoagain.numberbaseball.model.AnswerBall;
import io.github.sogoagain.numberbaseball.model.PitchingBall;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AnswerBallTest {
    @Test
    public void test_AnswerBallTest() throws Exception {
        PitchingBall candiateBall = PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(123));
        AnswerBall answerBall = new AnswerBall(candiateBall);
        PitchingBall pitchingBall = PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(142));

        assertThat(answerBall.countSamePosition(pitchingBall)).isEqualTo(1);
        assertThat(answerBall.countSameValue(pitchingBall)).isEqualTo(2);
    }
}