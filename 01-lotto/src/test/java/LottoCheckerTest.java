import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoCheckerTest {

    private LottoChecker lottoChecker;

    public LottoCheckerTest() throws Exception {
        LottoNumber winningNumber = LottoNumber.fromManualSelection(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        lottoChecker = new LottoChecker(winningNumber);
    }

    @Test
    public void testFirstPlace() throws Exception {
        LottoNumber entryNumber1 = LottoNumber.fromManualSelection(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        assertThat(lottoChecker.checkRanking(entryNumber1)).isEqualByComparingTo(LottoRankType.FIRST_PLACE);

        LottoNumber entryNumber2 = LottoNumber.fromManualSelection(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,8)));
        assertThat(lottoChecker.checkRanking(entryNumber2)).isEqualByComparingTo(LottoRankType.FIRST_PLACE);
    }

    @Test
    public void testSecondPlace() throws Exception {
        LottoNumber entryNumber = LottoNumber.fromManualSelection(new ArrayList<>(Arrays.asList(1,2,3,4,5,8,7)));
        assertThat(lottoChecker.checkRanking(entryNumber)).isEqualByComparingTo(LottoRankType.SECOND_PLACE);
    }

    @Test
    public void testThirdPlace() throws Exception {
        LottoNumber entryNumber = LottoNumber.fromManualSelection(new ArrayList<>(Arrays.asList(1,2,3,4,5,8,9)));
        assertThat(lottoChecker.checkRanking(entryNumber)).isEqualByComparingTo(LottoRankType.THIRD_PLACE);
    }

    @Test
    public void testFourthPlace() throws Exception {
        LottoNumber entryNumber = LottoNumber.fromManualSelection(new ArrayList<>(Arrays.asList(1,2,3,4,8,9,7)));
        assertThat(lottoChecker.checkRanking(entryNumber)).isEqualByComparingTo(LottoRankType.FOURTH_PLACE);
    }

    @Test
    public void testFifthPlace() throws Exception {
        LottoNumber entryNumber = LottoNumber.fromManualSelection(new ArrayList<>(Arrays.asList(1,2,3,8,9,10,7)));
        assertThat(lottoChecker.checkRanking(entryNumber)).isEqualByComparingTo(LottoRankType.FIFTH_PLACE);
    }

    @Test
    public void testNextTime() throws Exception {
        LottoNumber entryNumber = LottoNumber.fromManualSelection(new ArrayList<>(Arrays.asList(8,9,10,11,12,13,14)));
        assertThat(lottoChecker.checkRanking(entryNumber)).isNull();
    }
}