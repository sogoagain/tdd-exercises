package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.model.PitchingBall;
import io.github.sogoagain.numberbaseball.model.PitchingResult;

public interface PlayingStrategy {
    PitchingBall nextBall();
    void recordHistory(PitchingResult result);
}
