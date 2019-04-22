package Lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST("1등", 6)
    , SECOND("2등", 5)
    , THIRD("3등", 5)
    , FOURTH("4등", 4)
    , FIFTH("5등", 3);
    // TO-DO: 꽝 처리
    private String title;
    private int matchCount;

    Rank(String title, int matchCount) {
        this.title = title;
        this.matchCount = matchCount;
    }

    public static Rank valueOf(int matchCount, boolean isSameBonusBall) {
        if (matchCount == SECOND.matchCount) {
            return isSameBonusBall ? SECOND : THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return this.title;
    }
}
