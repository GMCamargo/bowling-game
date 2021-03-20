package com.jobsity;

import com.jobsity.Utils.Utils;
import com.jobsity.exceptions.GameException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.Game;
import com.jobsity.models.BowlingGame;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    static Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.FINEST);

        try {
        //input file reading
        String inputFileName = args.length > 0 ? args[0] : "input.txt";
        File file = new File(inputFileName);
        BufferedReader br = new BufferedReader(new FileReader(file));


        String line = br.readLine();
        Game bowling = new BowlingGame();
        boolean gameStarted = false;

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

            } else {
                System.err.println("Game couldn't start");
            }


            br.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid entry");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Not enough rounds");
        } catch (InvalidRoundException e) {
            System.err.println(e.getMessage());
        } catch (GameException e) {
            System.err.println(e.getMessage());
        }catch (FileNotFoundException e){
            System.err.println("Input file not found, game couldn't start");
        }
    }
}
