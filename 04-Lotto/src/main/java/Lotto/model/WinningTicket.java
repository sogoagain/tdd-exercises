package Lotto.model;

import java.util.Objects;

public class WinningTicket {
    private Ticket ticket;
    private Ball bonus;

    public WinningTicket(Ticket ticket, Ball bonus) {
        checkDuplicate(ticket, bonus);
        this.ticket = ticket;
        this.bonus = bonus;
    }

    private void checkDuplicate(Ticket ticket, Ball bonus) {
        if (ticket.contains(bonus)) {
            throw new IllegalArgumentException("Bonus 숫자가 중복됩니다.");
        }
    }

    public Rank getRank(Ticket otherTicket) {
        int matchCountOfBalls = ticket.match(otherTicket);
        boolean isSameBonusBall = otherTicket.contains(bonus);

        return Rank.valueOf(matchCountOfBalls, isSameBonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningTicket)) return false;
        WinningTicket winningTicket = (WinningTicket) o;
        return ticket.equals(winningTicket.ticket) &&
                bonus.equals(winningTicket.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, bonus);
    }
}
