package Lotto.controller;

import Lotto.view.WinningObserver;

public class RandomSimulation implements Simulation{

    private int timesOfSimulation;

    @Override
    public void initialize(int timesOfSimulation) {
        this.timesOfSimulation = timesOfSimulation;
    }

    @Override
    public void start() {

    }

    @Override
    public void registerObserver(WinningObserver o) {

    }

    @Override
    public void removeObserver(WinningObserver o) {

    }
}
