package io.github.sogoagain.numberbaseball.model;

import java.util.List;

public class PitchingBall {
    public static final int BALL_SIZE = 3;

    protected List<Ball> balls;

    public PitchingBall(List<Ball> balls) {
        checkBallCount(balls);
        checkDuplicatedValue(balls);
        this.balls = balls;
    }

    private void checkBallCount(List<Ball> balls) {
        if(balls.size() != BALL_SIZE) {
            throw new IllegalArgumentException("Number of balls out of range");
        }
    }

    private void checkDuplicatedValue(List<Ball> balls){
        boolean isDuplicated = balls.stream()
                    .distinct()
                    .count() != balls.size();

        if(isDuplicated) {
            throw new IllegalArgumentException("has duplicated value");
        }
    }

    @Override
    public String toString() {
        return "PitchingBall{" +
                "balls=" + balls +
                '}';
    }
}
