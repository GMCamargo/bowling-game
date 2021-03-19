package com.jobsity.models;

import com.jobsity.interfaces.Player;
import com.jobsity.interfaces.Score;
import com.jobsity.interfaces.dict.EntryEnum;

import java.util.LinkedList;

public class Bowler implements Player {

    private String name;
    private BowlingScore score;
    private int position;
    int timesPlayed = 0;

    public Bowler(String name, EntryEnum pins, int position) throws Exception {
        this.name = name;
        this.score = new BowlingScore();
        this.position = position;
        registry_play(pins,0);
    }

    public void registry_play(EntryEnum pins, int currentRound) throws Exception {
        score.registry_play(pins,currentRound);
        timesPlayed++;
    }

    public int getPosition() {
        return position;
    }

    public void printPlayerScores() {
        System.out.println(name);
        score.printScore();
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
