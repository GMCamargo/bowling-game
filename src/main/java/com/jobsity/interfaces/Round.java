package com.jobsity.interfaces;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.interfaces.dict.EntryEnum;

import java.util.ArrayList;

public interface Round {
    void registry_play(EntryEnum pins) throws InvalidEntryException;
    int getPlayScore(int i);

}
