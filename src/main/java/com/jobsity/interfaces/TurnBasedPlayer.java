package com.jobsity.interfaces;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.interfaces.dict.EntryEnum;

public interface TurnBasedPlayer extends Player{
    /**
     *
     * @param entry
     * @param currentRound
     * @throws InvalidEntryException
     */
    void registryPlay(EntryEnum entry, int currentRound) throws InvalidEntryException;

    /**
     *
     * @return
     */
    int getPosition();
}
