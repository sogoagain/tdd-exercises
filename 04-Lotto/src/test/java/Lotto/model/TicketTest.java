package Lotto.model;

import Lotto.model.Ball;
import Lotto.model.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class TicketTest {

    private Set<Ball> ballSet = new HashSet<>();

    @Before
    public void init() {
        initBallSet(ballSet);
    }

    private void initBallSet(Set<Ball> ballSet) {
        for (int i = 1; i <= Ticket.SIZE; i++) {
            Ball ball = Ball.valueOf(i);
            ballSet.add(ball);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_overSizeNumbers() throws Exception {
        int maximum_value = Ball.MAXIMUM_VALUE;
        Ball newBall = Ball.valueOf(maximum_value);
        ballSet.add(newBall);

        Ticket ticket = new Ticket(ballSet);
    }

    @Test
    public void test_equals() throws Exception {
        Set<Ball> otherBallSet = new HashSet<>();
        initBallSet(otherBallSet);

        Ticket ticket = new Ticket(ballSet);
        Ticket otherTicket = new Ticket(otherBallSet);

        boolean result = ticket.equals(otherTicket);
        assertThat(result).isEqualTo(true);
    }
}