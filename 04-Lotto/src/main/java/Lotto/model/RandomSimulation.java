package Lotto.model;

import Lotto.view.ViewObserver;

import java.util.*;

public class RandomSimulation implements Simulation{

    private ViewObserver viewObserver;

    // 단계를 나눠보자.
    // 시물레이션 결과를 한번에 통
    @Override
    public void simulate(int numberOfTimes) {
        Results results = new Results();

        WinningTicket winningTicket = RandomTicketGenerator.createRandomWinningTicket();
        viewObserver.updateWinningTicket(winningTicket);

        for (int i = 0; i < numberOfTimes; i++) {
            Ticket ticket = RandomTicketGenerator.createRandomTicket();
            Rank rank = winningTicket.getRank(ticket);

            results.put(rank);
            viewObserver.updateWinningStatus(ticket, rank);
        }
        Map<Rank, Integer> statistics = results.getStatistics();
        viewObserver.updateSimulationResults(statistics);
    }

    @Override
    public void registerObserver(ViewObserver o) {
        viewObserver = o;
    }

    @Override
    public void removeObserver(ViewObserver o) {
        viewObserver = null;
    }
}
