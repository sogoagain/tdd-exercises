package Lotto.model;

import Lotto.view.ViewObserver;

public interface Simulation {
    void simulate(int numberOfTimes);

    void registerObserver(ViewObserver o);

    void removeObserver(ViewObserver o);
}
