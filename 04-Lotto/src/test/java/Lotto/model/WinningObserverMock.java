package Lotto.model;

import Lotto.view.WinningObserver;

import java.util.Map;

public class WinningObserverMock implements WinningObserver {
    private int countOfCallWinningTicket = 0;
    private int countOfCallStatus = 0;
    private int countOfCallResult = 0;

    @Override
    public void updateWinningTicket(WinningTicket winningTicket) {
        countOfCallWinningTicket++;
    }

    @Override
    public void updateWinningStatus(Ticket ticket, Rank rank) {
        countOfCallStatus++;
    }

    @Override
    public void updateSimulationResults(Map<Rank, Integer> results) {
        countOfCallResult++;
    }

    public int getCountOfCallWinningTicket() {
        return countOfCallWinningTicket;
    }

    public int getCountOfCallStatus() {
        return countOfCallStatus;
    }

    public int getCountOfCallResult() {
        return countOfCallResult;
    }
}
