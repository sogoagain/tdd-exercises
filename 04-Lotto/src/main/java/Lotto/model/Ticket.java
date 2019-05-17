package Lotto.model;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// 팩터리 메서드 추가 고려
public class Ticket {
    public static final int SIZE = 6;

    private final Set<Ball> balls;

    public Ticket(Set<Ball> balls) {
        checkSize(balls);
        this.balls = balls;
    }

    private void checkSize(Set<Ball> ballList) {
        if (ballList.size() != SIZE) {
            throw new IllegalArgumentException("Balls의 허용된 크기와 다릅니다.");
        }
    }

    public int match(Ticket other) {
        Set<Ball> otherSet = new HashSet<>(other.balls);
        otherSet.retainAll(balls);

        return otherSet.size();
    }

    public boolean contains(Ball ball) {
        return balls.contains(ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket1 = (Ticket) o;
        return balls.equals(ticket1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    @Override
    public String toString() {
        return "" +
                balls;
    }
}
