package com.jobsity.interfaces;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.dict.EntryEnum;

public interface Score {
    /**
     * Register the play into the score
     * @param entry the players entry
     * @param currentRound current round
     * @throws InvalidEntryException thrown if there's a invalid entry
     */
    void registryPlay(EntryEnum entry, int currentRound) throws InvalidEntryException;

    /**
     * Prints the score
     * @return the score
     * @throws InvalidRoundException thrown if there's a invalid round
     */
    String printScore() throws InvalidRoundException;

}
