package io.github.sogoagain.numberbaseball.View;

import io.github.sogoagain.numberbaseball.model.PitchingBall;
import io.github.sogoagain.numberbaseball.model.PitchingResult;

public class ConsoleOutput {
    public static void printStart() {
        System.out.println("--- 경기 시작 ---");
    }

    public static void printEnd() {
        System.out.println("--- 경기 종료 ---");
    }

    public static void printRoundResult(PitchingResult result) {
        System.out.println(result.toString());
    }

    public static void printRound(int round) {
        System.out.println(round + "회");
    }

    public static void printPitchingBall(PitchingBall ball) {
        System.out.println(ball.toString());
    }
}
