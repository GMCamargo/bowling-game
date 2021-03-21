package com.jobsity.models;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.BowlingGameScore;
import com.jobsity.interfaces.TurnBasedPlayer;
import com.jobsity.interfaces.dict.EntryEnum;

public class Bowler implements TurnBasedPlayer {

    private String name;
    private BowlingGameScore score;
    private int position;
    int timesPlayed = 0;

    public Bowler(String name, EntryEnum pins, int position) throws InvalidEntryException {
        this.name = name;
        this.score = new BowlingScore();
        this.position = position;
        registryPlay(pins,0);
    }

    public void registryPlay(EntryEnum pins, int currentRound) throws InvalidEntryException {
        score.registryPlay(pins,currentRound);
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
