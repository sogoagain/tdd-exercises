package Lotto.view;

import Lotto.model.Rank;
import Lotto.model.Ticket;
import Lotto.model.WinningTicket;

import java.util.Map;

public interface WinningObserver {
    void updateWinningTicket(WinningTicket winningTicket);

    void updateWinningStatus(Ticket ticket, Rank rank);

    void updateSimulationResults(Map<Rank, Integer> results);
}
