package io.github.sogoagain.model;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
    public static final int GOAL_POINT = 21;
    private static final int ACE_CARD_CALIBRATION_POINT = 10;
    private List<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }

    public int getPoint() {
        return calculatePoint();
    }

    private int calculatePoint() {
        int point = sumRanks();
        if(hasAceCard() && needToCorrectAceCard(point)) {
            point = point + ACE_CARD_CALIBRATION_POINT;
        }

        return point;
    }

    private int sumRanks() {
        return cards.stream().map(Card::getRank).mapToInt(i -> i).sum();
    }

    private boolean hasAceCard() {
        for (Card.Suit suit :
                Card.Suit.values()) {
            if (cards.contains(Card.of(suit, Card.Rank.ACE))) {
                return true;
            }
        }
        return false;
    }

    private boolean needToCorrectAceCard(int point) {
        int defaultDifference = Math.abs(GOAL_POINT - point);
        int calibrationDifference = Math.abs(GOAL_POINT - (point + ACE_CARD_CALIBRATION_POINT));
        return  (calibrationDifference <= GOAL_POINT) && (calibrationDifference < defaultDifference);
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
