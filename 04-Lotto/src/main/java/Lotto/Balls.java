package Lotto;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Balls {
    public static final int SIZE = 6;

    private final Set<Ball> balls;

    public Balls(Set<Ball> balls) {
        checkSize(balls);
        this.balls = balls;
    }

    private void checkSize(Set<Ball> ballList) {
        if (ballList.size() != SIZE) {
            throw new IllegalArgumentException("Balls의 허용된 크기와 다릅니다.");
        }
    }

    public int match(Balls other) {
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
        if (!(o instanceof Balls)) return false;
        Balls balls1 = (Balls) o;
        return balls.equals(balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
