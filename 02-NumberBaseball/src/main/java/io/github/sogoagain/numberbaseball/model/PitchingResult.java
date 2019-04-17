package io.github.sogoagain.numberbaseball.model;

import java.util.Arrays;

public class PitchingResult {
    private int[] resultCount;

    public PitchingResult(int strike, int ball, int out) {
        resultCount = new int[ResultType.values().length];

        resultCount[ResultType.STRIKE.ordinal()] = strike;
        resultCount[ResultType.BALL.ordinal()] = ball;
        resultCount[ResultType.OUT.ordinal()] = out;
    }

    public boolean isAllStrike() {
        return resultCount[ResultType.STRIKE.ordinal()] == PitchingBall.BALL_SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PitchingResult)) return false;
        PitchingResult that = (PitchingResult) o;
        return Arrays.equals(resultCount, that.resultCount);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(resultCount);
    }

    @Override
    public String toString() {
        return "[" + ResultType.STRIKE.toString() + ": " + resultCount[ResultType.STRIKE.ordinal()] + "]"
                + "[" + ResultType.BALL.toString() + ": " + resultCount[ResultType.BALL.ordinal()] + "]"
                + "[" + ResultType.OUT.toString() + ": " + resultCount[ResultType.OUT.ordinal()] + "]";
    }
}
