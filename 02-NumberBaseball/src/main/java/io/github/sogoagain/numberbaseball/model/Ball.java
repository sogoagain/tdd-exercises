package io.github.sogoagain.numberbaseball.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ball implements Comparable<Ball> {
    public static final int MINIMUN_OF_BALL = 1;
    public static final int MAXIMUM_OF_BALL = 9;

    private static final Map<Integer, Ball> CACHE_OF_BALLS = new HashMap<>();
    private int number;

    private Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        if(number < MINIMUN_OF_BALL || number > MAXIMUM_OF_BALL) {
            throw new IllegalArgumentException("Out of range: " + number);
        }

        if (CACHE_OF_BALLS.containsKey(number)) {
            return CACHE_OF_BALLS.get(number);
        }

        Ball ball = new Ball(number);
        CACHE_OF_BALLS.put(number, ball);
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Ball o) {
        return Integer.compare(number, o.number);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "number=" + number +
                '}';
    }
}
