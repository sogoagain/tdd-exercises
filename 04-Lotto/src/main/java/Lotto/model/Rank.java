package Lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6)
    , SECOND(5)
    , THIRD(5)
    , FOURTH(4)
    , FIFTH(3);

    private int matchCount;

    Rank(int matchCount) {
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
}
