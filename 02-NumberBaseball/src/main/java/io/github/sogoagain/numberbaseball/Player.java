package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.model.PitchingBall;
import io.github.sogoagain.numberbaseball.model.PitchingResult;

public class Player {
    private PitchingResult result;
    private PlayingStrategy strategy;

    public Player(PlayingStrategy strategy) {
        setStrategy(strategy);
    }

    private void setStrategy(PlayingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setResult(PitchingResult result) {
        strategy.recordHistory(result);
    }

    public PitchingBall nextBall() {
        return strategy.nextBall();
    }
}
