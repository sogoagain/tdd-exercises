package io.github.sogoagain;

import io.github.sogoagain.model.CardDeck;

public class User extends Player {

    private static final int BET_RATE = 2;
    private static final int INITIAL_CAPITAL = 500;
    private int wallet = INITIAL_CAPITAL;
    private int betMoney = 0;

    User(CardDeck deck) {
        super(deck);
    }

    void bet(int money) {
        betMoney = money;
        wallet -= money;
    }

    public void win() {
        wallet += betMoney * BET_RATE;
    }

    public int getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        return "{" + hand +
                ", point=" + point +
                '}';
    }
}
