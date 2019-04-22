package Lotto.model;

import Lotto.view.ConsoleView;
import org.junit.Test;

public class RandomSimulationTest {

    private RandomSimulation randomSimulation = new RandomSimulation();

    @Test (expected = NullPointerException.class)
    public void test_notRegisterObserver() throws Exception {
        randomSimulation.initialize(1000);
        randomSimulation.start();
    }

    // 목 객체로 테스트
    @Test
    public void test_lessThan0Times() throws Exception {
        ConsoleView view = new ConsoleView();
        randomSimulation.registerObserver(view);

        randomSimulation.initialize(-1);
        randomSimulation.start();
    }

    @Test
    public void test_simulateTest() throws Exception {
        ConsoleView view = new ConsoleView();
        randomSimulation.registerObserver(view);

        randomSimulation.initialize(1000);
        randomSimulation.start();
    }
}