package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.View.ConsoleOutput;
import io.github.sogoagain.numberbaseball.model.AnswerBall;
import io.github.sogoagain.numberbaseball.model.PitchingBall;
import io.github.sogoagain.numberbaseball.model.PitchingResult;

public class PlayGround {
    public static final int MAX_ROUND = 9;

    private Referee referee;
    private Player player;

    public PlayGround() {
        referee = new Referee();
        player = new Player(new InputStrategy());
        // player = new Player(new ComputeStrategy());
    }

    public void play() {
        ConsoleOutput.printStart();

        PitchingBall candiateBall = PitchingBallFactory.getPitchingBall(new PitchingBallRandomFactory());
        referee.setAnswerBall(candiateBall);

        ConsoleOutput.printPitchingBall(candiateBall);

        for(int i = 1; !isGameEnd(i); i++) {
            roundPlay(i);
        }
    }

    private boolean isGameEnd(int round) {
        return referee.isGameEnd() || round == MAX_ROUND;
    }

    private boolean roundPlay(int round) {
        ConsoleOutput.printRound(round);

        PitchingBall pitchingBall = player.nextBall();
        PitchingResult result = referee.judgePitchingBall(pitchingBall);
        player.setResult(result);

        ConsoleOutput.printPitchingBall(pitchingBall);
        ConsoleOutput.printRoundResult(result);

        return referee.isGameEnd();
    }
}
