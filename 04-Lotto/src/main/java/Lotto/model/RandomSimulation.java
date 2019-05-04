package Lotto.model;

import Lotto.view.ViewObserver;

import java.util.*;

public class RandomSimulation implements Simulation{

    private ViewObserver viewObserver;

    @Override
    public void simulate(int numberOfTimes) {
        Results results = new Results();

        WinningTicket winningTicket = TicketGenerator.createRandomWinningTicket();
        viewObserver.updateWinningTicket(winningTicket);

        for (int i = 0; i < numberOfTimes; i++) {
            Ticket ticket = TicketGenerator.createRandomTicket();
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
