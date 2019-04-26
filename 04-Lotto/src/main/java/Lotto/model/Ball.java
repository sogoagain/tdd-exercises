package Lotto.model;

import java.util.Objects;

public class Ball implements Comparable<Ball> {

    public static final int MINIMUM_VALUE = 1;
    public static final int MAXIMUM_VALUE = 45;

    private int value;
    private Ball(int value) {
        this.value = value;
    }

    private static class BallCache {
        static final Ball cache[];

        static {
            cache = new Ball[(MAXIMUM_VALUE - MINIMUM_VALUE) + 1];
            int j = MINIMUM_VALUE;
            for (int i = 0; i < cache.length; i++)
                cache[i] = new Ball(j++);
        }

        public static int getIndex(int i) {
            return i - MINIMUM_VALUE;
        }

        private BallCache() {}
    }

    public static Ball valueOf(int i) {
        if (i < MINIMUM_VALUE || i > MAXIMUM_VALUE) {
            throw new IllegalArgumentException("로또 숫자 범위를 벗어났습니다.");
        }
        int index = BallCache.getIndex(i);
        return BallCache.cache[index];
    }

    @Override
    public int compareTo(Ball o) {
        Integer value = this.value;
        return value.compareTo(o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
