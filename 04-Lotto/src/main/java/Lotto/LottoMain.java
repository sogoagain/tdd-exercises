package Lotto;

import Lotto.controller.Controller;
import Lotto.controller.SimulationController;
import Lotto.model.RandomSimulation;
import Lotto.model.Simulation;

public class LottoMain {
    public static void main(String[] args) {
        Simulation simulation = new RandomSimulation();
        Controller controller = new SimulationController(simulation);
        controller.start();
    }
}
