package io.github.sogoagain.numberbaseball.model;

import java.util.List;

public class AnswerBall extends PitchingBall {
    public AnswerBall(PitchingBall pitchingBall) {
        super(pitchingBall.balls);
    }

    public int countSameValue(PitchingBall pitchingBall) {
        return (int) this.balls.stream()
                .filter(pitchingBall.balls::contains)
                .count();
    }

    public int countSamePosition(PitchingBall pitchingBall) {
        int count = 0;
        for (int i = 0; i < PitchingBall.BALL_SIZE; i++) {
            if (this.balls.get(i) == pitchingBall.balls.get(i)) {
                count++;
            }
        }
        return count;
    }
}
