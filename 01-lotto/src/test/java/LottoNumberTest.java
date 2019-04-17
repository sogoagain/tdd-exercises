import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    public void testManualSelection() throws Exception {
        assertThatThrownBy(() -> {
            List<Integer> outOfCountNumbers = new ArrayList<>(Arrays.asList(1, 23, 32, 43, 23, 54, 65, 34, 43, 54));
            LottoNumber lottoNumber = LottoNumber.fromManualSelection(outOfCountNumbers);
        }).isInstanceOf(WrongLottoNumberException.class).hasMessageContaining("Number Count Error");

        assertThatThrownBy(() -> {
            List<Integer> outOfRangeNumbers = new ArrayList<>(Arrays.asList(1, 42, 45, 3, 23, 39, 2));
            LottoNumber lottoNumber = LottoNumber.fromManualSelection(outOfRangeNumbers);
        }).isInstanceOf(WrongLottoNumberException.class).hasMessageContaining("Range Error");

        assertThatThrownBy(() -> {
            List<Integer> duplicateNumbers = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2));
            LottoNumber lottoNumber = LottoNumber.fromManualSelection(duplicateNumbers);
        }).isInstanceOf(WrongLottoNumberException.class).hasMessageContaining("duplicate Error");
    }


    @Test
    public void testAutoSelection() throws Exception {
        LottoNumber lottoNumber = LottoNumber.fromAutoSelection();
        assertThat(lottoNumber.getBaseNumbers().size()).isEqualTo(LottoNumber.LOTTO_NUMBER_COUNT - 1);
        assertThat(lottoNumber.getAllNumbers().size()).isEqualTo(LottoNumber.LOTTO_NUMBER_COUNT);
        assertThat(lottoNumber.getBonusNumber()).isBetween(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER);
        for (int number : lottoNumber.getAllNumbers()) {
            assertThat(number).isBetween(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER);
        }
    }
}