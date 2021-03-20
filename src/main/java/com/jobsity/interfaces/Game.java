package com.jobsity.interfaces;

import com.jobsity.exceptions.GameException;
import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.dict.EntryEnum;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public interface Game {
    EntryEnum processEntry(String entry) throws InvalidEntryException;
    void play(String name, String entry) throws GameException;
    String printPlayersScores() throws InvalidRoundException, IOException;
}
