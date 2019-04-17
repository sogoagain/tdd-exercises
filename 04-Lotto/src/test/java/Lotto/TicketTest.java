package Lotto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class TicketTest {

    private Balls balls;
    private Ball bonus;

    @Before
    public void init() {
        int minimum = Ball.MINIMUM_VALUE;
        balls = createBalls(minimum);
    }

    private Balls createBalls(int minimum) {
        Set<Ball> ballSet = new HashSet<>();

        for (int i = minimum; i < Balls.SIZE + minimum; i++) {
            Ball ball = Ball.valueOf(i);
            ballSet.add(ball);
        }

        return new Balls(ballSet);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_duplicateListAndBonus() throws Exception {
        int minimumValue = Ball.MINIMUM_VALUE;
        bonus = Ball.valueOf(minimumValue);

        Ticket ticket = new Ticket(balls, bonus);
    }

    @Test
    public void test_equals() throws Exception {
        int maximumValue = Ball.MAXIMUM_VALUE;
        int minimumValue = Ball.MINIMUM_VALUE;
        bonus = Ball.valueOf(maximumValue);
        Ticket ticket = new Ticket(balls, bonus);

        Balls balls1 = createBalls(minimumValue);
        Ball bonus1 = Ball.valueOf(maximumValue);
        Ticket ticket1 = new Ticket(balls1, bonus1);

        boolean result = ticket.equals(ticket1);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void test_win1st() throws Exception {
        int maximumValue = Ball.MAXIMUM_VALUE;
        int minimumValue = Ball.MINIMUM_VALUE;
        bonus = Ball.valueOf(maximumValue);
        Ticket ticket = new Ticket(balls, bonus);

        Balls balls1 = createBalls(minimumValue);
        Ball bonus1 = Ball.valueOf(maximumValue);
        Ticket ticket1 = new Ticket(balls1, bonus1);

        Rank rank = ticket.getRank(ticket1);
        assertThat(rank).isEqualByComparingTo(Rank.FIRST);
    }


    @Test
    public void test_win2nd() throws Exception {
        int maximumValue = Ball.MAXIMUM_VALUE;
        int minimumValue = Ball.MINIMUM_VALUE;
        bonus = Ball.valueOf(maximumValue);
        Ticket ticket = new Ticket(balls, bonus);

        Balls balls1 = createBalls(minimumValue + 1);
        Ball bonus1 = Ball.valueOf(maximumValue);
        Ticket ticket1 = new Ticket(balls1, bonus1);

        Rank rank = ticket.getRank(ticket1);
        assertThat(rank).isEqualByComparingTo(Rank.SECOND);
    }

    @Test
    public void test_win3nd() throws Exception {
        int maximumValue = Ball.MAXIMUM_VALUE;
        int minimumValue = Ball.MINIMUM_VALUE;
        bonus = Ball.valueOf(maximumValue);
        Ticket ticket = new Ticket(balls, bonus);

        Balls balls1 = createBalls(minimumValue + 1);
        Ball bonus1 = Ball.valueOf(maximumValue - 1);
        Ticket ticket1 = new Ticket(balls1, bonus1);

        Rank rank = ticket.getRank(ticket1);
        assertThat(rank).isEqualByComparingTo(Rank.THIRD);
    }

    @Test
    public void test_win4th() throws Exception {
        int maximumValue = Ball.MAXIMUM_VALUE;
        int minimumValue = Ball.MINIMUM_VALUE;
        bonus = Ball.valueOf(maximumValue);
        Ticket ticket = new Ticket(balls, bonus);

        Balls balls1 = createBalls(minimumValue + 2);
        Ball bonus1 = Ball.valueOf(maximumValue);
        Ticket ticket1 = new Ticket(balls1, bonus1);

        Rank rank = ticket.getRank(ticket1);
        assertThat(rank).isEqualByComparingTo(Rank.FOURTH);
    }

    @Test
    public void test_win5th() throws Exception {
        int maximumValue = Ball.MAXIMUM_VALUE;
        int minimumValue = Ball.MINIMUM_VALUE;
        bonus = Ball.valueOf(maximumValue);
        Ticket ticket = new Ticket(balls, bonus);

        Balls balls1 = createBalls(minimumValue + 3);
        Ball bonus1 = Ball.valueOf(maximumValue);
        Ticket ticket1 = new Ticket(balls1, bonus1);

        Rank rank = ticket.getRank(ticket1);
        assertThat(rank).isEqualByComparingTo(Rank.FIFTH);
    }
}