package com.jobsity;

import com.jobsity.interfaces.Game;
import com.jobsity.models.BowlingGame;

import java.io.BufferedOutputStream;
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
        BufferedOutputStream result = new BufferedOutputStream(System.out);

        String line = br.readLine();
        Game bowling = new BowlingGame();
        try {
            while (!line.isEmpty() && !line.equals("\n")) {
                String[] nameAndPins = line.split(" ");
                String name = nameAndPins[0];
                String entry = nameAndPins[1];

                bowling.play(name, entry);

                line = br.readLine();
            }

            bowling.printPlayersScores();
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Invalid entry");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
