package Lotto.controller;

import Lotto.model.Simulation;
import Lotto.view.ConsoleView;

public class SimulationController implements Controller{

    private Simulation model;
    private ConsoleView view = new ConsoleView();

    public SimulationController(Simulation model) {
        this.model = model;
        model.registerObserver(view);
    }

    @Override
    public void start() {
        int timesOfSimulation = view.inputTimesToSimulate();
        model.initialize(timesOfSimulation);
        model.start();
    }
}
