public enum LottoRankType {
    FIRST_PLACE(6, 0),
    SECOND_PLACE(5, 1),
    THIRD_PLACE(5, 2),
    FOURTH_PLACE(4, 3),
    FIFTH_PLACE(3, 4);

    private int matchCount;
    private int rankIndex;

    LottoRankType(int matchCount, int rankIndex) {
        this.matchCount = matchCount;
        this.rankIndex = rankIndex;
    }

    public static LottoRankType valueOf(int matchCount, boolean correctBonusNumber) {
        if(matchCount == LottoRankType.SECOND_PLACE.matchCount) {
            if(correctBonusNumber) {
                return LottoRankType.SECOND_PLACE;
            }
            return LottoRankType.THIRD_PLACE;
        }

        for(LottoRankType rank : LottoRankType.values()) {
            if(rank.matchCount == matchCount) {
                return rank;
            }
        }
        return null;
    }

    public int getRankIndex() {
       return rankIndex;
    }
}
