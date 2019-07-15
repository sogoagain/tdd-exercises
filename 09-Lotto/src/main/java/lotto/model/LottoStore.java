package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.controller.Simulator;
import lotto.view.InputView;

public class LottoStore {
    private static final int COUNT_OF_ONE = 1;

    public static List<Ticket> generateTickets(int countOfManualTickets, int countOfAutomaticTickets) {
        List<Ticket> manualTickets = generateManualTickets(countOfManualTickets);
        List<Ticket> automaticTickets = generateAutomaticTickets(countOfAutomaticTickets);
        return Stream.concat(manualTickets.stream(), automaticTickets.stream())
                     .collect(Collectors.toList());
    }

    private static List<Ticket> generateAutomaticTickets(int countOfAutomaticTickets) {
        return Simulator.buyTickets(new AutomaticTicketGenerator(), countOfAutomaticTickets);
    }

    private static List<Ticket> generateManualTickets(int countOfManualTickets) {
        List<Ticket> manualTickets = new ArrayList<>();
        for (int i = 0; i < countOfManualTickets; i++) {
            List<Integer> manualNumbers = InputView.inputManualNumbers();
            List<Ticket> tickets = Simulator.buyTickets(new ManualTicketGenerator(manualNumbers), COUNT_OF_ONE);
            manualTickets.addAll(tickets);
        }
        return manualTickets;
    }
}
