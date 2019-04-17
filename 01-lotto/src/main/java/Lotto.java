public class Lotto {
    public static void main(String[] args) {
        LottoAnalyzer analyzer = new LottoAnalyzer(1000);
        analyzer.simulate();
        System.out.println(analyzer.toString());
    }
}
