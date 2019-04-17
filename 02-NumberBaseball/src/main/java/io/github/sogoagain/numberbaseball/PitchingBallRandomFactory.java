package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.model.Ball;
import io.github.sogoagain.numberbaseball.model.PitchingBall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PitchingBallRandomFactory implements PitchingBallAbstractFactory {

    @Override
    public PitchingBall generate() {
        return new PitchingBall(generateRandomBalls());
    }

    private List<Ball> generateRandomBalls() {
        List<Ball> balls = new ArrayList<>();

        while(balls.size() < PitchingBall.BALL_SIZE) {
            Ball ball = generateRandomBall();
            insertBall(balls, ball);
        }

        return balls;
    }

    private Ball generateRandomBall() {
        int randomNumber = new Random().nextInt(Ball.MAXIMUM_OF_BALL) + 1;
        return Ball.of(randomNumber);
    }


    private void insertBall(List<Ball> balls, Ball ball) {
        if(balls.contains(ball)) {
            return;
        }
        balls.add(ball);
    }
}
