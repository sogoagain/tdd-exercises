package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.View.ConsoleInput;
import io.github.sogoagain.numberbaseball.View.ConsoleOutput;
import io.github.sogoagain.numberbaseball.model.PitchingBall;
import io.github.sogoagain.numberbaseball.model.PitchingResult;

import java.util.Scanner;

public class InputStrategy implements PlayingStrategy {
    @Override
    public PitchingBall nextBall() {
        int userInput = scanUserInput();
        return PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(userInput));
    }

    @Override
    public void recordHistory(PitchingResult result) {

    }

    private int scanUserInput() {
        return ConsoleInput.inputInt();
    }
}
