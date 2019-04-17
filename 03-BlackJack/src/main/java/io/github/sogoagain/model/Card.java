package io.github.sogoagain.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card {

    public enum Suit {
        SPADE(1, "♠")
        , HEART(2, "♥")
        , DIAMOND(3, "♦")
        , CLUB(4, "♣");

        private int value;
        private String shape;

        Suit(int value, String shape) {
            this.value = value;
            this.shape = shape;
        }
    }

    public enum Rank {
        ACE(1, "A")
        , TWO(2, "2")
        , THREE(3, "3")
        , FOUR(4, "4")
        , FIVE(5, "5")
        , SIX(6, "6")
        , SEVEN(7, "7")
        , EIGHT(8, "8")
        , NINE(9, "9")
        , TEN(10, "10")
        , JACK(10, "J")
        , QUEEN(10, "Q")
        , KING(10, "K");

        private int value;
        private String name;

        Rank(int value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    private static final Map<Integer, Card> CACHE = new HashMap<>();
    private Suit suit;
    private Rank rank;


    private Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static Card of(Suit suit, Rank rank) {
        int cardValue = getCardValue(suit, rank);

        if(!CACHE.containsKey(cardValue)) {
            Card card = new Card(suit, rank);
            CACHE.put(cardValue, card);
        }

        return CACHE.get(cardValue);
    }

    private static int getCardValue(Suit suit, Rank rank) {
        return suit.ordinal()*10 + rank.ordinal();
    }

    int getRank() {
        return rank.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return suit.shape + rank.name;
    }
}
