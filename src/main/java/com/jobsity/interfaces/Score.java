package com.jobsity.interfaces;

import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.dict.EntryEnum;

public interface Score {

    void registry_play(EntryEnum pins, int currentRound) throws Exception;
    String printScore() throws InvalidRoundException;

}
