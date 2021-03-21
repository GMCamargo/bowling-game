package com.jobsity.interfaces;

import com.jobsity.exceptions.GameException;
import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.dict.EntryEnum;
 /**
 * This class has the main methods to a interactive game
 */
public interface Game {
     /**
      *
      * @param entry the entry of a determined player
      * @return Returns a enum identifying the mark to the game
      * @throws InvalidEntryException identify a invalid entry
      */
    EntryEnum processEntry(String entry) throws InvalidEntryException;

     /**
      * Executes the game
      * @param name name of the player
      * @param entry entry of the player
      * @throws GameException exception thrown for error in the game processing
      */
    void play(String name, String entry) throws GameException;

     /**
      * Prints the score of each player
      * @return a string with the score of each player
      * @throws InvalidRoundException exception thrown if there's a invalid entry in the round
      */
    String printPlayersScores() throws InvalidRoundException;
}
