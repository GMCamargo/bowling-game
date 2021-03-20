package com.jobsity.interfaces;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.dict.EntryEnum;

public interface Player {
    void registry_play(EntryEnum pins, int currentRound) throws InvalidEntryException;
    int getPosition();
    String printPlayerScores() throws InvalidRoundException;
    int getTimesPlayed();
    void resetTimesPlayed();
}
