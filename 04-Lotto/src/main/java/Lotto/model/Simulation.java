package Lotto.model;

import Lotto.view.WinningObserver;

public interface Simulation {
    void initialize(int timesOfSimulation);

    void start();

    void registerObserver(WinningObserver o);

    void removeObserver(WinningObserver o);
}
