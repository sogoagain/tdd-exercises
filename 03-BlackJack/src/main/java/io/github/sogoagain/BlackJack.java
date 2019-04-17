package io.github.sogoagain;

import io.github.sogoagain.model.CardDeck;
import io.github.sogoagain.view.UserInterface;

class BlackJack {
    private UserInterface userInterface = new UserInterface();

    private CardDeck deck;
    private User user;
    private Dealer dealer;

    BlackJack() {
        init();
    }

    void play() {

        while(userInterface.confirmMakeDeal()) {
            cardInit();
            betMoney();
            pullFirst2Cards();
            HitStand();
            pullDealer();
            getWinner();
        }

    }

    private void cardInit() {
        deck.init();
        deck.shuffle();
        user.init(deck);
        dealer.init(deck);
    }

    private void getWinner() {
        Player player = dealer.isWin(user);
        if(player == null) {
            userInterface.printDraw();
            return;
        }
        player.win();

        userInterface.printWinner(player);
    }

    private void pullDealer() {
        dealer.pullLastCards();
        userInterface.printCardHand(dealer);
        if(dealer.isBust()) {
            return;
        }
    }

    private void HitStand() {
        while(userInterface.confirmHitStand()) {
            user.pullCard();
            userInterface.printCardHand(user);
            if(user.isBust()) {
                return;
            }
        }
    }

    private void betMoney() {
        userInterface.printMoney(user);
        int betMoney = userInterface.inputBatMoney();
        user.bet(betMoney);
    }

    private void pullFirst2Cards() {
        user.pullCard();
        user.pullCard();
        dealer.pullCard();
        dealer.pullCard();

        userInterface.printDealerHand(dealer);
        userInterface.printCardHand(user);
    }

    private void init() {
        deck = new CardDeck();
        deck.init();
        deck.shuffle();
        user = new User(deck);
        dealer = new Dealer(deck);
    }
}
