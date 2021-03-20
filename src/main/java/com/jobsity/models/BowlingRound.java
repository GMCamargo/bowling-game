package com.jobsity.models;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.Round;
import com.jobsity.interfaces.dict.EntryEnum;

import java.util.ArrayList;

public class BowlingRound implements Round {
    ArrayList<String> plays = new ArrayList<String>();
    ArrayList<Integer> playScore = new ArrayList<Integer>();

    //The number of pins downed
    int downedPins = 0;
    //The score of the round
    private int roundScore = 0;
    //flags if the round has a strike
    boolean spare, strike = false;


    public void registry_play(EntryEnum pins) throws InvalidEntryException {
        downedPins += pins.getValue();
        plays.add(convertToMark(pins));
        playScore.add(pins.getValue());
    }

    //TODO: ARRUMAR ISSO AQUI (Não pode aceitar se downedpins > 10, não aceitar mais que 2 bolas)
    private String convertToMark(EntryEnum pins){
        if (pins == EntryEnum.STRIKE && (plays.isEmpty() || downedPins > 10)) {
            strike = true;
            return "X";
        } else if (downedPins == 10 && !strike) {
            spare = true;
            return "/";
        } else if (pins == EntryEnum.FOUL) {
            return "F";
        }

        return pins.getStringValue();
    }

    public String getAllPlays() {
        StringBuilder result = new StringBuilder();
        for (String p :
                plays) {
            result.append(p).append("\t");
        }
        return result.toString();
    }

    public int getRoundScore() {
        return roundScore;
    }

    public int getDownedPins(int round) throws InvalidRoundException {
        if (round < 9 && downedPins > 10) {
            throw new InvalidRoundException("Invalid value entry in round " + round);
        } else if (round == 9) {
            if (!(strike || spare) && downedPins > 10) {
                throw new InvalidRoundException("Invalid value entry in round " + round);
            }
        }
        return downedPins;
    }

    public boolean hasStrike() {
        return strike;
    }

    public boolean hasSpare() {
        return spare;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }

    public int getPlayScore(int i) {
        return i > 0 ? playScore.get(i) : 0;
    }
}
