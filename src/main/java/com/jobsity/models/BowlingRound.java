package com.jobsity.models;

import com.jobsity.interfaces.Round;
import com.jobsity.interfaces.dict.EntryEnum;

import java.util.ArrayList;

public class BowlingRound implements Round {
    ArrayList<String> plays = new ArrayList<String>();
    ArrayList<Integer> play_score = new ArrayList<Integer>();

    //The number of pins downed
    int downedPins = 0;
    //The score of the round
    private int roundScore = 0;
    //flags if the round has a strike
    boolean spare, strike = false;


    public void registry_play(EntryEnum pins) throws Exception {
        downedPins += pins.getValue();
        plays.add(convertToMark(pins));
        play_score.add(pins.getValue());
    }

    //TODO: ARRUMAR ISSO AQUI (Não pode aceitar se downedpins > 10, não aceitar mais que 2 bolas)
    private String convertToMark(EntryEnum pins){

        if (pins == EntryEnum.STRIKE) {
            strike = true;
            return "X";
        } else if (downedPins == 10) {
            spare = true;
            return "/";
        } else if (pins == EntryEnum.ZERO) {
            return "-";
        }else if (pins == EntryEnum.FOUL){
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

    public int getDownedPins() {
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
        return i > 0 ? play_score.get(i) : 0;
    }
}
