package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.model.Ball;
import io.github.sogoagain.numberbaseball.model.PitchingBall;

import java.util.ArrayList;
import java.util.List;

public class PitchingBallDigitsFactory implements PitchingBallAbstractFactory {

    int digits;

    public PitchingBallDigitsFactory(int digits) {
        checkNegativeNumber(digits);
        checkDigitsLength(digits);
        this.digits = digits;
    }

    private void checkDigitsLength(int digits) {
        int length = (int)(Math.log10(digits) + 1);
        if(length != 3) {
            throw new IllegalArgumentException("digits length is wrong");
        }
    }

    private void checkNegativeNumber(int digits) {
        if(digits <= 0) {
            throw new IllegalArgumentException("digits is negative number");
        }
    }

    @Override
    public PitchingBall generate() {
        List<Ball> balls = new ArrayList<>();

        balls.add(Ball.of(digits/100));
        balls.add(Ball.of(digits/10%10));
        balls.add(Ball.of(digits%10));

        return new PitchingBall(balls);
    }

}
