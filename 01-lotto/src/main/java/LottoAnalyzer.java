public class LottoAnalyzer {

    public static final int NUMBER_OF_ANALYSIS_TARGET = 5;

    private int testCase;
    private LottoChecker checker;
    private int[] results = new int[NUMBER_OF_ANALYSIS_TARGET];

    public LottoAnalyzer(int testCase) {
        this.testCase = testCase;
        checker = new LottoChecker(LottoNumber.fromAutoSelection());
    }

    public void simulate() {
        for(int i = 0; i < testCase; i++) {
            LottoNumber winningNumber = LottoNumber.fromAutoSelection();
            LottoRankType rankType = checker.checkRanking(winningNumber);

            if(rankType == null) {
                continue;
            }
            results[rankType.getRankIndex()]++;
        }
    }

    @Override
    public String toString() {
        String resultString = "";

        for(int i = 0; i < results.length; i++) {
            resultString += (i+1) + "등: " + results[i] + "  ";
        }

        return resultString;
    }
}
