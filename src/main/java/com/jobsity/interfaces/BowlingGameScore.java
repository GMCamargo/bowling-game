package com.jobsity.interfaces;

public interface BowlingGameScore extends Score {
    /**
     * Check if there is a strike in the current round
     * @param round current round
     * @return true if there's a strike in a determined round
     */
    boolean hasStrikeInCurrentRound(int round);

}
