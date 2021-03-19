package com.jobsity.interfaces;

import com.jobsity.interfaces.dict.EntryEnum;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public interface Game {
    EntryEnum processEntry(String entry) throws Exception;
    void play(String name, String entry) throws Exception;
    void printPlayersScores();
}
