package com.jobsity.models;

import com.jobsity.interfaces.Game;
import com.jobsity.interfaces.Player;
import com.jobsity.interfaces.dict.EntryEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public class BowlingGame implements Game {
    private int round = 0;
    private int currentPlayer = 0;
    private LinkedHashMap<String, Bowler> players = new LinkedHashMap<String, Bowler>();

    public void play(String name, String entry) throws Exception {



        if (!players.containsKey(name) && round == 0) {
            players.put(name, new Bowler(name, processEntry(entry), currentPlayer));
            if (players.get(name).getTimesPlayed() == 2 || players.get(name).hasStrikeInCurrentRound(round))
                passTurn(name);
        } else if (players.get(name) != null) {
            passRound();
            if (players.get(name).getPosition() == currentPlayer) {
                players.get(name).registry_play(processEntry(entry), round);
                if (round != 9) {
                    if (players.get(name).hasStrikeInCurrentRound(round)) {
                        passTurn(name);
                    } else if (players.get(name).getTimesPlayed() == 2) {
                        passTurn(name);
                    }
                } else {
                    if (players.get(name).getTimesPlayed() == 3)
                        passTurn(name);
                }
            } else {
                throw new Exception("It's not " + name + "'s turn");
            }
        } else {
            throw new Exception("Player " + name + " is not able to play now");
        }
    }

    private void passRound() {
        if (currentPlayer == players.size()) {
            round++;
            currentPlayer = 0;
        }
    }

    public void printPlayersScores() {
        System.out.println("Frame" + "\t\t" + 1 + "\t\t" + 2 + "\t\t" + 3 + "\t\t" + 4 + "\t\t" + 5 + "\t\t" + 6 + "\t\t" + 7 + "\t\t" + 8 + "\t\t" + 9 + "\t\t" + 10);
        for (Map.Entry<String, Bowler> b :
                players.entrySet()) {
            b.getValue().printPlayerScores();
        }
    }

    void passTurn(String name) {
        currentPlayer++;
        players.get(name).resetTimesPlayed();
    }
    @Override
    public EntryEnum processEntry(String entry) throws Exception {
        switch (entry) {
            case "F":
                return EntryEnum.FOUL;
            case "0":
                return EntryEnum.ZERO;
            case "1":
                return EntryEnum.ONE;
            case "2":
                return EntryEnum.TWO;
            case "3":
                return EntryEnum.THREE;
            case "4":
                return EntryEnum.FOUR;
            case "5":
                return EntryEnum.FIVE;
            case "6":
                return EntryEnum.SIX;
            case "7":
                return EntryEnum.SEVEN;
            case "8":
                return EntryEnum.EIGHT;
            case "9":
                return EntryEnum.NINE;
            case "10":
                return EntryEnum.STRIKE;


        }
        throw new Exception("Entry value " + entry + " is not allowed");
    }
}
