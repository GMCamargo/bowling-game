package com.jobsity.models;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.Player;
import com.jobsity.interfaces.Score;
import com.jobsity.interfaces.dict.EntryEnum;

import java.util.LinkedList;

public class Bowler implements Player {

    private String name;
    private BowlingScore score;
    private int position;
    int timesPlayed = 0;

    public Bowler(String name, EntryEnum pins, int position) throws InvalidEntryException {
        this.name = name;
        this.score = new BowlingScore();
        this.position = position;
        registry_play(pins,0);
    }

    public void registry_play(EntryEnum pins, int currentRound) throws InvalidEntryException {
        score.registry_play(pins,currentRound);
        timesPlayed++;
    }

    public int getPosition() {
        return position;
    }

    public String printPlayerScores() throws InvalidRoundException {

        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        sb.append(score.printScore());

        return sb.toString();
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    @Override
    public void resetTimesPlayed() {
        this.timesPlayed = 0;
    }

    public boolean hasStrikeInCurrentRound(int round){
        return score.hasStrikeInCurrentRound(round);
    }
}
