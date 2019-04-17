package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.model.PitchingBall;

public class PitchingBallFactory {
    static public PitchingBall getPitchingBall(PitchingBallAbstractFactory pitchingBallAbstractFactory) {
        return pitchingBallAbstractFactory.generate();
    }
}
