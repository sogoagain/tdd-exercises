package Lotto.model;

import Lotto.view.WinningObserver;

import java.util.*;

public class RandomSimulation implements Simulation{

    private int timesOfSimulation;
    private WinningObserver winningObserver;

    @Override
    public void initialize(int timesOfSimulation) {
        this.timesOfSimulation = timesOfSimulation;
    }

    @Override
    public void start() {
        Results results = new Results();

        WinningTicket winningTicket = createRandomWinningTicket();
        winningObserver.updateWinningTicket(winningTicket);

        for (int i = 0; i < timesOfSimulation; i++) {
            Ticket ticket = createRandomTicket();
            Rank rank = winningTicket.getRank(ticket);

            results.put(rank);
            winningObserver.updateWinningStatus(ticket, rank);
        }
        Map<Rank, Integer> statistics = results.getStatistics();
        winningObserver.updateSimulationResults(statistics);
    }

    @Override
    public void registerObserver(WinningObserver o) {
        winningObserver = o;
    }

    @Override
    public void removeObserver(WinningObserver o) {
        winningObserver = null;
    }

    private Ticket createRandomTicket() {
        int ticketSize = Ticket.SIZE;
        return new Ticket(createBallSet(ticketSize));
    }

    private WinningTicket createRandomWinningTicket() {
        int winningTicketSize = Ticket.SIZE + 1;
        Set<Ball> ballSet = createBallSet(winningTicketSize);

        Iterator<Ball> iterator = ballSet.iterator();
        Ball bonusBall = iterator.next();
        iterator.remove();

        Ticket ticket = new Ticket(ballSet);
        return new WinningTicket(ticket, bonusBall);
    }

    private Set<Ball> createBallSet(int size) {
        Set<Ball> ballSet = new HashSet<>();

        while (ballSet.size() < size) {
            int maximumValue = Ball.MAXIMUM_VALUE;
            int randomNumber = new Random().nextInt(maximumValue) + 1;

            Ball ball = Ball.valueOf(randomNumber);
            ballSet.add(ball);
        }

        return ballSet;
    }
}
