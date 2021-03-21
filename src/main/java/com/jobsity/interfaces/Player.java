package com.jobsity.interfaces;

import com.jobsity.exceptions.InvalidRoundException;

/**
 * Represents a player
 * */
public interface Player {
    /**
     *
     * @return Returns a String with this player score
     * @throws InvalidRoundException thrown if there's a invalid round
     */
    String printPlayerScores() throws InvalidRoundException;

    /**
     * Gets the number of times this player has already played
     * @return the number of times player for this player
     */
    int getTimesPlayed();

    /**
     * resets the number of times player for this player
     */
    void resetTimesPlayed();
}
