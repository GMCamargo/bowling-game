package com.jobsity.interfaces;

import com.jobsity.interfaces.dict.EntryEnum;

public interface Player {
    void registry_play(EntryEnum pins, int currentRound) throws Exception;
    int getPosition();
    void printPlayerScores();
    int getTimesPlayed();
    void resetTimesPlayed();
}
