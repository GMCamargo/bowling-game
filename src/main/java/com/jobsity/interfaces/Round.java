package com.jobsity.interfaces;

import com.jobsity.interfaces.dict.EntryEnum;

import java.util.ArrayList;

public interface Round {
    void registry_play(EntryEnum pins) throws Exception;
    int getPlayScore(int i);

}
