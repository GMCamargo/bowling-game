package com.jobsity.interfaces;

import com.jobsity.exceptions.InvalidRoundException;

public interface BowlingGameRound extends Round {
    /**
     * Sets the round score
     * @param roundScore the score that should be registered
     */
    void setRoundScore(int roundScore);

    /**
     * gets the round score
     * @return the score of this round
     */
    int getRoundScore();

    /**
     * Identifies if there's a strike in this round
     * @return returns true if there's a strike in this round
     */
    boolean hasStrike();

    /**
     * Identifies if there's a spare in this round
     * @return returns true if there's a spare in this round
     */
    boolean hasSpare();

    /**
     * Return the total of downed pins this round
     * @param round the number of the round
     * @return the total of downed pins this round
     * @throws InvalidRoundException thrown if the round is invalid
     */
    int getDownedPins(int round) throws InvalidRoundException;
}
