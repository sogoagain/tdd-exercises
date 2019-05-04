package Lotto.view;

import Lotto.model.Rank;
import Lotto.model.Ticket;
import Lotto.model.WinningTicket;

import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements ViewObserver {

    public int inputTimesToSimulate() {
        System.out.print("시뮬레이션 횟수: ");
        Scanner scanner = new Scanner(System.in);

        int timesOfSimulation = scanner.nextInt();
        return timesOfSimulation;
    }

    @Override
    public void updateWinningTicket(WinningTicket winningTicket) {
        System.out.println("당첨번호: " + winningTicket);
    }

    @Override
    public void updateWinningStatus(Ticket ticket, Rank rank) {
        System.out.println("당첨! 등수: " + rank + ", 번호: " + ticket);
    }

    @Override
    public void updateSimulationResults(Map<Rank, Integer> results) {
        System.out.println("=== 통계 ===");

        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            System.out.print(rank + ": " + count + " ");
        }

        System.out.println();
    }
}
