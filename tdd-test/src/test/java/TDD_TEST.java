import org.junit.Test;
import static org.junit.Assert.*;

public class TDD_TEST {
    @Test(expected = NullPointerException.class)
    public void exception_test() {
        throw new NullPointerException();

    }

    @Test
    public void first_test() throws Exception {
        TDD tdd = new TDD();

        assertEquals(1, tdd.getNumberOne());
    }
}
