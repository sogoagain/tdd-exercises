package io.github.sogoagain;

import io.github.sogoagain.model.CardDeck;
import io.github.sogoagain.model.CardHand;

public class Dealer extends Player {

    Dealer(CardDeck deck) {
        super(deck);
    }

    void pullLastCards() {
        while(point <= 16) {
            pullCard();
        }
    }

    Player isWin(Player player) {
        if(player.isBust() || (Math.abs(this.point - CardHand.GOAL_POINT)) < (Math.abs(player.point - CardHand.GOAL_POINT))) {
            return this;
        }
        if(this.isBust() || (Math.abs(this.point - CardHand.GOAL_POINT)) > (Math.abs(player.point - CardHand.GOAL_POINT))) {
            return player;
        }
        return null;
    }

    public String dealerHandStatus() {
        return "{" + hand.toString().substring(0, 4) + "**]}";
    }

    @Override
    public void win() {
    }

    @Override
    public String toString() {
        return "{" + hand +
                ", point=" + point +
                '}';
    }
}
