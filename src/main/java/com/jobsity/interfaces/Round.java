package com.jobsity.interfaces;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.interfaces.dict.EntryEnum;

import java.util.ArrayList;
/**
 * Represents a single game round
 * */
public interface Round {
    /**
     * Registers the play made
     * @param entry entry of the player
     * @throws InvalidEntryException exception thrown if the entry is not valid
     */
    void registryPlay(EntryEnum entry) throws InvalidEntryException;

    /**
     * Get all plays in the round
     * @return All registered plays made in this round
     */
    String getAllPlays();
}
