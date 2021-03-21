package com.jobsity.models;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.BowlingGameRound;
import com.jobsity.interfaces.BowlingGameScore;
import com.jobsity.interfaces.dict.EntryEnum;
import java.util.LinkedList;

public class BowlingScore implements BowlingGameScore {
    BowlingGameRound[] rounds = new BowlingGameRound[10];
    int currentRound = 0;
    LinkedList<Integer> balls = new LinkedList<>();

    public BowlingScore() {
        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = new BowlingRound();
        }
    }

    public void registryPlay(EntryEnum pins, int currentRound) throws InvalidEntryException {
        this.currentRound = currentRound;
        if (!rounds[currentRound].hasStrike())
            rounds[currentRound].registryPlay(pins);
        else if (rounds[currentRound].hasStrike())
            if (currentRound == 9)
                rounds[currentRound].registryPlay(pins);
            else throw new InvalidEntryException("This play is not possible to be registered");

        balls.add(pins.getValue());
    }


    public String printScore() throws InvalidRoundException {
        int previousTurnScore = 0;


        StringBuilder pinfalls = new StringBuilder("Pinfalls\t");
        StringBuilder score = new StringBuilder("Score\t\t");

        for (int i = 0; i < 10; i++) {
            rounds[i].setRoundScore(calculateScore(i,previousTurnScore));
            previousTurnScore = rounds[i].getRoundScore();


            if (i < 9) {
                if (rounds[i].hasStrike()){
                    pinfalls.append("\t").append(rounds[i].getAllPlays());
                }else {
                    pinfalls.append(rounds[i].getAllPlays());
                }
                score.append(rounds[i].getRoundScore()).append("\t\t");

            } else {
                String s = rounds[i].getAllPlays();
                pinfalls.append(s.subSequence(0, s.length() - 1));
                score.append(rounds[i].getRoundScore());
            }
        }

        return pinfalls + "\n" + score + "\n";
    }

    private int calculateScore(int round, int previousTurnScore) throws InvalidRoundException {


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
            result += rounds[round].getDownedPins(round);
        }
        return result;
    }

    public boolean hasStrikeInCurrentRound(int round) {
        return rounds[round].hasStrike();
    }
}
