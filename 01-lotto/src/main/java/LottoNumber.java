import java.util.*;

public class LottoNumber {

    public static final int LOTTO_NUMBER_COUNT = 7;
    public static final int LOTTO_MAX_NUMBER = 42;
    public static final int LOTTO_MIN_NUMBER = 1;

    private Set<Integer> baseNumbers;
    private int bonusNumber;

    private LottoNumber(List<Integer> numbers) {
        bonusNumber = popInNumbers(numbers);
        baseNumbers = new HashSet<>(numbers);
    }

    public static LottoNumber fromManualSelection(List<Integer> numbers) throws Exception {
        if(!checkCountOfNumbers(numbers)) {
            throw new WrongLottoNumberException("Number Count Error");
        }
        if(!checkRangeOfNumbers(numbers)) {
            throw new WrongLottoNumberException("Range Error");
        }
        if(!checkDuplicates(numbers)) {
            throw new WrongLottoNumberException("duplicate Error");
        }

        return new LottoNumber(numbers);
    }


    public static LottoNumber fromAutoSelection() {
        List<Integer> numbers = new ArrayList<>();
        while (!checkCountOfNumbers(numbers)) {
            int randomNumber = generateRandomNumber();
            numbers.add(randomNumber);

            if(!checkDuplicates(numbers)) {
                popInNumbers(numbers);
            }
        }

        return new LottoNumber(numbers);
    }

    private static Integer popInNumbers(List<Integer> numbers) {
        return numbers.remove((numbers.size() - 1));
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(LOTTO_MAX_NUMBER) + 1;
    }


    private static boolean checkDuplicates(List<Integer> numbers) {
        if(new HashSet<>(numbers).size() != numbers.size()) {
            return false;
        }
        return true;
    }

    private static boolean checkRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCountOfNumbers(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBER_COUNT) {
           return false;
        }
        return true;
    }


    public Set<Integer> getBaseNumbers() {
        return baseNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getAllNumbers() {
        List<Integer> allNumbers = new ArrayList<>(baseNumbers);
        allNumbers.add(bonusNumber);

        return allNumbers;
    }

    @Override
    public String toString() {
        String string = "";

        for(int number : baseNumbers) {
            string += number + ", ";
        }
        string += bonusNumber;
        return string;
    }

}
