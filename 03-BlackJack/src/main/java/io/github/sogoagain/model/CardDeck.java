package io.github.sogoagain.model;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {
    private Stack<Card> cards = new Stack<>();

    public void init() {
        for (Card.Suit suit :
                Card.Suit.values()) {
            for (Card.Rank rank :
                    Card.Rank.values()) {
                cards.push(Card.of(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card popCard() {
        return cards.pop();
    }

    public int size() {
        return cards.size();
    }
}
