package Lotto.model;

import Lotto.model.Ball;
import Lotto.model.Rank;
import Lotto.model.Ticket;
import Lotto.model.WinningTicket;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class WinningTicketTest {
    private int minimumValue = Ball.MINIMUM_VALUE;
    private int maximumValue = Ball.MAXIMUM_VALUE;

    private Ticket ticket;
    private Ball bonus;

    @Before
    public void init() {
        int minimum = Ball.MINIMUM_VALUE;
        ticket = createTicketWithIncreasingBy1(minimum);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_duplicateListAndBonus() throws Exception {
        int minimumValue = Ball.MINIMUM_VALUE;
        bonus = Ball.valueOf(minimumValue);

        WinningTicket winningTicket = new WinningTicket(ticket, bonus);
        assertThat(winningTicket).isInstanceOf(WinningTicket.class);
    }

    @Test
    public void test_equals() throws Exception {
        bonus = Ball.valueOf(maximumValue);
        WinningTicket winningTicket = new WinningTicket(ticket, bonus);

        Ticket otherTicket = createTicketWithIncreasingBy1(minimumValue);
        Ball otherBonus = Ball.valueOf(maximumValue);
        WinningTicket otherWinningTicket = new WinningTicket(otherTicket, otherBonus);

        boolean result = winningTicket.equals(otherWinningTicket);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void test_win1st() throws Exception {
        Rank rank = getRank(maximumValue, minimumValue);
        assertThat(rank).isEqualByComparingTo(Rank.FIRST);
    }


    @Test
    public void test_win2nd() throws Exception {
        int numberFor2ndRank = 7;
        Rank rank = getRank(numberFor2ndRank, minimumValue + 1);
        assertThat(rank).isEqualByComparingTo(Rank.SECOND);
    }

    @Test
    public void test_win3nd() throws Exception {
        Rank rank = getRank(maximumValue, minimumValue + 1);
        assertThat(rank).isEqualByComparingTo(Rank.THIRD);
    }

    @Test
    public void test_win4th() throws Exception {
        Rank rank = getRank(maximumValue, minimumValue + 2);
        assertThat(rank).isEqualByComparingTo(Rank.FOURTH);
    }

    @Test
    public void test_win5th() throws Exception {
        Rank rank = getRank(maximumValue, minimumValue + 3);
        assertThat(rank).isEqualByComparingTo(Rank.FIFTH);
    }

    private Ticket createTicketWithIncreasingBy1(int minimum) {
        Set<Ball> ballSet = new HashSet<>();

        for (int i = minimum; i < Ticket.SIZE + minimum; i++) {
            Ball ball = Ball.valueOf(i);
            ballSet.add(ball);
        }

        return new Ticket(ballSet);
    }

    private Rank getRank(int bonusValue, int startingValueOfTicket) {
        bonus = Ball.valueOf(bonusValue);
        WinningTicket winningTicket = new WinningTicket(ticket, bonus);

        Ticket otherTicket = createTicketWithIncreasingBy1(startingValueOfTicket);

        return winningTicket.getRank(otherTicket);
    }
}