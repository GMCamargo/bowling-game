package com.jobsity;

import com.jobsity.Utils.Utils;
import com.jobsity.exceptions.GameException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.Game;
import com.jobsity.models.BowlingGame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Game bowling = new BowlingGame();
        boolean gameStarted = false;
        try {
            while (!Utils.isBlank(line)) {
                String[] nameAndPins = line.split(" ");
                String name = nameAndPins[0];
                String entry = nameAndPins[1];

                bowling.play(name, entry);

                line = br.readLine();
                gameStarted = true;
            }

            if (gameStarted)
                System.out.println(bowling.printPlayersScores());
            else {
                System.out.println("Game couldn't start");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Invalid entry");
            e.printStackTrace();
        }catch (IndexOutOfBoundsException e){
            System.err.println("Not enough rounds");
            e.printStackTrace();
        }catch (InvalidRoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (GameException e) {
            e.printStackTrace();
        }
    }
}
