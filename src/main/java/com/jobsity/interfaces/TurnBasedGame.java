package com.jobsity.interfaces;

public interface TurnBasedGame extends Game {
    /**
     * Passes turn knowing the player that is playing now
     * @param name name of the current playing player
     */
    void passTurn(String name);

    /**
     * Passes the round to the next player
     */
    void passRound();
}
