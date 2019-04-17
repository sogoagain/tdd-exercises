import io.github.sogoagain.numberbaseball.PitchingBallDigitsFactory;
import io.github.sogoagain.numberbaseball.PitchingBallFactory;
import io.github.sogoagain.numberbaseball.Referee;
import io.github.sogoagain.numberbaseball.model.PitchingBall;
import io.github.sogoagain.numberbaseball.model.PitchingResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class RefereeTest {
    @Test
    public void test_RefereeTest() throws Exception {
        Referee referee = new Referee();
        PitchingBall answerBall = PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(123));
        PitchingBall pitchingBall = PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(132));

        referee.setAnswerBall(answerBall);
        PitchingResult result = referee.judgePitchingBall(pitchingBall);
        PitchingResult expectedResult = new PitchingResult(1, 2, 0);

        assertThat(result.equals(expectedResult)).isEqualTo(true);
    }
}