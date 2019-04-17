import java.util.HashSet;
import java.util.Set;

public class LottoChecker {

    private LottoNumber winningNumbers;
    private LottoNumber entryNumbers;

    public LottoChecker(LottoNumber winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoRankType checkRanking(LottoNumber entryNumber) {
        this.entryNumbers = entryNumber;
        return compareNumber();
    }

    private LottoRankType compareNumber() {
        Set<Integer> intersection = new HashSet<>(winningNumbers.getBaseNumbers());
        intersection.retainAll(entryNumbers.getBaseNumbers());

        return LottoRankType.valueOf(intersection.size(), isCorrectBonusNumber());

    }

    private boolean isCorrectBonusNumber() {
       return winningNumbers.getBonusNumber() == entryNumbers.getBonusNumber();
    }
}
