package com.jobsity.models;

import com.jobsity.interfaces.Round;
import com.jobsity.interfaces.Score;
import com.jobsity.interfaces.dict.EntryEnum;

import java.util.ArrayList;
import java.util.LinkedList;

public class BowlingScore implements Score {
    BowlingRound[] rounds = new BowlingRound[10];
    int currentRound = 0;
    LinkedList<Integer> balls = new LinkedList<>();

    public BowlingScore() {
        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = new BowlingRound();
        }
    }

    public void registry_play(EntryEnum pins, int currentRound) throws Exception {
        this.currentRound = currentRound;
        if (!rounds[currentRound].hasStrike())
            rounds[currentRound].registry_play(pins);
        else if (rounds[currentRound].hasStrike())
            if (currentRound == 9)
                rounds[currentRound].registry_play(pins);
            else throw new Exception("This play is not possible to be registered");

        balls.add(pins.getValue());
    }


    public void printScore() {
        int previousTurnScore = 0;


        StringBuilder pinfalls = new StringBuilder("Pinfalls\t");
        StringBuilder score = new StringBuilder("Score\t\t");

        for (int i = 0; i < 10; i++) {
            rounds[i].setRoundScore(calculateScore(i,previousTurnScore));
            previousTurnScore = rounds[i].getRoundScore();


            if (rounds[i].hasStrike() && i < 9) {
                pinfalls.append("\t").append(rounds[i].getAllPlays());
            } else {
                pinfalls.append(rounds[i].getAllPlays());
            }

            score.append(rounds[i].getRoundScore()).append("\t\t");
        }

        System.out.println(pinfalls);
        System.out.println(score);

    }

    public int calculateScore(int round, int previousTurnScore) {


        int result = previousTurnScore;

        if (rounds[round].hasStrike()){
            Integer currentBall = balls.pop();
            result+= currentBall;
            for (int i = 0; i < 2; i++) {
                result += balls.get(i);
            }
        }else if (rounds[round].hasSpare()){
            balls.pop();
            balls.pop();
            result += 10 + balls.getFirst();
        }else {
            balls.pop();
            balls.pop();
            result += rounds[round].getDownedPins();
        }
        return result;
    }

    public boolean hasStrikeInCurrentRound(int round) {
        return rounds[round].hasStrike();
    }
}
