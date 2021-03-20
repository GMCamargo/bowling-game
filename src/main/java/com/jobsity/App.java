package com.jobsity;

import com.jobsity.Utils.Utils;
import com.jobsity.exceptions.GameException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.Game;
import com.jobsity.models.BowlingGame;

import java.io.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        //input file reading
        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));

        //output file configuration
        String outputFileName = args.length > 1 ? args[1] : "output.txt";
        FileOutputStream outputStream = new FileOutputStream(outputFileName);


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

            if (gameStarted) {
                String scores = bowling.printPlayersScores();
                System.out.println(scores);
                outputStream.write(scores.getBytes());

            } else {
                System.out.println("Game couldn't start");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid entry");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Not enough rounds");
            e.printStackTrace();
        } catch (InvalidRoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (GameException e) {
            e.printStackTrace();
        }

        outputStream.close();
        br.close();


    }
}
