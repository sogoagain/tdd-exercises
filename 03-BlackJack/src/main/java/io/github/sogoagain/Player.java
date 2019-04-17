package io.github.sogoagain;

import io.github.sogoagain.model.Card;
import io.github.sogoagain.model.CardDeck;
import io.github.sogoagain.model.CardHand;

public abstract class Player {
    private CardDeck deck;
    CardHand hand;
    int point = 0;

    Player(CardDeck deck) {
        init(deck);
    }

    void pullCard() {
        Card card = deck.popCard();
        hand.add(card);
        point = hand.getPoint();
    }

    boolean isBust() {
        return point > CardHand.GOAL_POINT;
    }

    void init(CardDeck deck) {
        this.deck = deck;
        hand = new CardHand();
    }

    public abstract void win();
}
