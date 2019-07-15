package lotto;

import lotto.controller.Simulator;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoMain {
    public static void main(String[] args) {
        int investMoney = InputView.inputInvestMoney();
        int countOfManualTickets = InputView.inputCountOfManualTicket();
        int countOfAutomaticTickets = Simulator.getCountOfAutomaticTicket(investMoney, countOfManualTickets);

        OutputView.printInformationForManualInput();
        List<Ticket> tickets = LottoStore.generateTickets(countOfManualTickets, countOfAutomaticTickets);

        OutputView.printNumberOfTickets(countOfManualTickets, countOfAutomaticTickets);
        for (Ticket ticket : tickets) {
            OutputView.printTicket(ticket);
        }

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningTicket winningTicket = Simulator.drawWinningTicket(winningNumbers, bonusNumber);

        Statistics statistics = Simulator.simulate(tickets, winningTicket);
        OutputView.printResult(statistics);

        int purchasePrice = Simulator.getPurchasePrice(investMoney);
        double profitRate = statistics.calculateProfitRate(Money.valueOf(purchasePrice));
        OutputView.printProfitRatio(profitRate);
    }
}
