package Lotto.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class TicketGenerator {
    public static Ticket createRandomTicket() {
        int ticketSize = Ticket.SIZE;
        return new Ticket(createBallSet(ticketSize));
    }

    public static WinningTicket createRandomWinningTicket() {
        int winningTicketSize = Ticket.SIZE + 1;
        Set<Ball> ballSet = createBallSet(winningTicketSize);

        Iterator<Ball> iterator = ballSet.iterator();
        Ball bonusBall = iterator.next();
        iterator.remove();

        Ticket ticket = new Ticket(ballSet);
        return new WinningTicket(ticket, bonusBall);
    }

    private static Set<Ball> createBallSet(int size) {
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
