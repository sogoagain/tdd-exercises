package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.model.AnswerBall;
import io.github.sogoagain.numberbaseball.model.PitchingBall;
import io.github.sogoagain.numberbaseball.model.PitchingResult;

public class Referee {
    private AnswerBall answerBall;
    private PitchingResult pitchingResult;

    public void setAnswerBall(PitchingBall answerBall) {
        this.answerBall = new AnswerBall(answerBall);
    }

    public PitchingResult judgePitchingBall(PitchingBall ball) {
        int strikeCount = judgeStrike(ball);
        int ballCount = judgeBall(ball);
        int outCount = PitchingBall.BALL_SIZE - strikeCount - ballCount;

        pitchingResult = new PitchingResult(strikeCount, ballCount, outCount);
        return pitchingResult;
    }

    public boolean isGameEnd() {
        if(pitchingResult == null) {
            return false;
        }
        return pitchingResult.isAllStrike();
    }

    private int judgeStrike(PitchingBall ball) {
        return answerBall.countSamePosition(ball);
    }

    private int judgeBall(PitchingBall ball) {
        return answerBall.countSameValue(ball) - judgeStrike(ball);
    }
}
