package Lotto;

import java.util.Objects;

public class Ticket {
    private Balls balls;
    private Ball bonus;

    public Ticket(Balls balls, Ball bonus) {
        checkDuplicate(balls, bonus);
        this.balls = balls;
        this.bonus = bonus;
    }

    private void checkDuplicate(Balls balls, Ball bonus) {
        if (balls.contains(bonus)) {
            throw new IllegalArgumentException("Ticket의 숫자가 중복됩니다.");
        }
    }

    public Rank getRank(Ticket other) {
        Balls otherBalls = other.balls;
        Ball otherBonus = other.bonus;

        int matchCountOfBalls = balls.match(otherBalls);
        boolean isSameBonusBall = bonus.equals(otherBonus);

        return Rank.valueOf(matchCountOfBalls, isSameBonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return balls.equals(ticket.balls) &&
                bonus.equals(ticket.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls, bonus);
    }
}
