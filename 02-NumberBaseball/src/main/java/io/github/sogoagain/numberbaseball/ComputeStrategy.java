package io.github.sogoagain.numberbaseball;

import io.github.sogoagain.numberbaseball.model.PitchingBall;
import io.github.sogoagain.numberbaseball.model.PitchingResult;

import java.util.*;

public class ComputeStrategy implements PlayingStrategy{
    private PitchingBall ball;
    private List<Integer> candidateList = new LinkedList<>();


    public ComputeStrategy() {
        initializeCandidateList();
    }

    private void initializeCandidateList() {
        for(int i = 111; i < 999; i++) {
            if(isDuplicated(i) || hasZero(i)) {
                continue;
            }
            candidateList.add(i);
        }
    }

    private boolean hasZero(int i) {
        return (i/100 == 0) || (i/10%10 == 0) || (i%10 == 0);
    }

    private boolean isDuplicated(int i) {
        Set<Integer> set = new HashSet<>();
        set.add(i/100);
        set.add(i/10%10);
        set.add(i%10);

        return set.size() != PitchingBall.BALL_SIZE;
    }

    @Override
    public PitchingBall nextBall() {
        Integer number = candidateList.get(0);
        ball =  PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(number));
        return ball;
    }

    @Override
    public void recordHistory(PitchingResult result) {
        Referee referee = new Referee();
        referee.setAnswerBall(ball);

        Iterator<Integer> iter = candidateList.iterator();
        while (iter.hasNext()) {
            Integer number = iter.next();

            PitchingBall candidateBall = PitchingBallFactory.getPitchingBall(new PitchingBallDigitsFactory(number));
            PitchingResult candidateResult = referee.judgePitchingBall(candidateBall);

            if(!result.equals(candidateResult)) {
                iter.remove();
            }
        }
    }
}
