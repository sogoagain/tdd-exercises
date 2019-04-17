package io.github.sogoagain.view;

import io.github.sogoagain.Dealer;
import io.github.sogoagain.Player;
import io.github.sogoagain.User;

import java.util.Scanner;

public class UserInterface {

    private void print(String str) {
        System.out.println(str);
    }

    public boolean confirmMakeDeal() {
        print("=== Deal 하시겠습니까? (Y/N) ===");

        return new Scanner(System.in).nextLine().equals("Y");
    }

    public int inputBatMoney() {
        print("=== 배당 금액을 입력하세요 ===");
        return new Scanner(System.in).nextInt();
    }

    public boolean confirmHitStand() {
        print("= HIT? STAND? (H/S)");

        return new Scanner(System.in).nextLine().equals("H");
    }

    public void printDraw() {
        print("=== 비겼습니다. ===");
    }

    public void printWinner(Player player) {
        String className = player.getClass().getSimpleName();
        print("=== " + className.substring(className.lastIndexOf('.') + 1) + "의 승리입니다. ===");
    }

    public void printCardHand(Player player) {
        print(player.getClass().getSimpleName() + " " + player.toString());
    }

    public void printMoney(User user) {
        print("- 보유금: " + user.getWallet());
    }

    public void printDealerHand(Dealer dealer) {
        print("Dealer: " + dealer.dealerHandStatus());
    }
}
