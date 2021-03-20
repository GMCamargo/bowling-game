package com.jobsity;

import com.jobsity.exceptions.GameException;
import com.jobsity.models.BowlingGame;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Integration test of the game
 */
public class AppTest {
    /**
     * Perfect score testing
     */

    String PERFECT_SCORE_RESPONSE =
                        "Frame" + "\t\t" + 1 + "\t\t" + 2 + "\t\t" + 3 + "\t\t" + 4 + "\t\t" + 5 + "\t\t" + 6 + "\t\t" + 7 + "\t\t" + 8 + "\t\t" + 9 + "\t\t" + 10 + "\n" +
                        "Carl\n"+
                        "Pinfalls\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\tX\tX\tX\n" +
                        "Score\t\t30\t\t60\t\t90\t\t120\t\t150\t\t180\t\t210\t\t240\t\t270\t\t300\n";


    String ZERO_SCORE_RESPONSE =
                    "Frame" + "\t\t" + 1 + "\t\t" + 2 + "\t\t" + 3 + "\t\t" + 4 + "\t\t" + 5 + "\t\t" + 6 + "\t\t" + 7 + "\t\t" + 8 + "\t\t" + 9 + "\t\t" + 10 + "\n" +
                    "Carl\n"+
                    "Pinfalls\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\n" +
                    "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\n";

    String TWO_PLAYER_EXPECTED_RESPONSE =
            "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n" +
                    "Jeff\n" +
                    "Pinfalls\t\tX\t7\t/\t9\t0\t\tX\t0\t8\t8\t/\tF\t6\t\tX\t\tX\tX\t8\t1\n" +
                    "Score\t\t20\t\t39\t\t48\t\t66\t\t74\t\t84\t\t90\t\t120\t\t148\t\t167\n" +
                    "John\n" +
                    "Pinfalls\t3\t/\t6\t3\t\tX\t8\t1\t\tX\t\tX\t9\t0\t7\t/\t4\t4\tX\t9\t0\n" +
                    "Score\t\t16\t\t25\t\t44\t\t53\t\t82\t\t101\t\t110\t\t124\t\t132\t\t151\n";
    @Test
    public void testingPerfectScore() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Carl 10"); //round 1
        list.add("Carl 10"); //round 2
        list.add("Carl 10"); //round 3
        list.add("Carl 10"); //round 4
        list.add("Carl 10"); //round 5
        list.add("Carl 10"); //round 6
        list.add("Carl 10"); //round 7
        list.add("Carl 10"); //round 8
        list.add("Carl 10"); //round 9
        list.add("Carl 10"); //round 10
        list.add("Carl 10");
        list.add("Carl 10");

        BowlingGame game = new BowlingGame();
        list.forEach((item) -> {
            String[] nameAndPins = item.split(" ");
            try {
                game.play(nameAndPins[0], nameAndPins[1]);
            } catch (GameException e) {
                Assert.fail(e.getMessage());
            }
        });

        try {
            Assert.assertEquals(PERFECT_SCORE_RESPONSE, game.printPlayersScores());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void testingZeroScore(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Carl 0"); //round 1
        list.add("Carl 0");
        list.add("Carl 0"); //round 2
        list.add("Carl 0");
        list.add("Carl 0"); //round 3
        list.add("Carl 0");
        list.add("Carl 0"); //round 4
        list.add("Carl 0");
        list.add("Carl 0"); //round 5
        list.add("Carl 0");
        list.add("Carl 0"); //round 6
        list.add("Carl 0");
        list.add("Carl 0"); //round 7
        list.add("Carl 0");
        list.add("Carl 0"); //round 8
        list.add("Carl 0");
        list.add("Carl 0"); //round 9
        list.add("Carl 0");
        list.add("Carl 0"); //round 10
        list.add("Carl 0");
        list.add("Carl 0");

        BowlingGame game = new BowlingGame();
        list.forEach((item) -> {
            String[] nameAndPins = item.split(" ");
            try {
                game.play(nameAndPins[0], nameAndPins[1]);
            } catch (GameException e) {
                Assert.fail(e.getMessage());
            }
        });

        try {
            Assert.assertEquals(ZERO_SCORE_RESPONSE, game.printPlayersScores());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void testingTwoPlayers(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Jeff 10"); //round 1
        list.add("John 3");
        list.add("John 7");
        list.add("Jeff 7"); //round 2
        list.add("Jeff 3");
        list.add("John 6");
        list.add("John 3");
        list.add("Jeff 9"); //round 3
        list.add("Jeff 0");
        list.add("John 10");
        list.add("Jeff 10");//round 4
        list.add("John 8");
        list.add("John 1");
        list.add("Jeff 0"); //round 5
        list.add("Jeff 8");
        list.add("John 10");
        list.add("Jeff 8"); //round 6
        list.add("Jeff 2");
        list.add("John 10");
        list.add("Jeff F"); //round 7
        list.add("Jeff 6");
        list.add("John 9");
        list.add("John 0");
        list.add("Jeff 10"); //round 8
        list.add("John 7");
        list.add("John 3");
        list.add("Jeff 10"); //round 9
        list.add("John 4");
        list.add("John 4");
        list.add("Jeff 10"); //round 10
        list.add("Jeff 8");
        list.add("Jeff 1");
        list.add("John 10");
        list.add("John 9");
        list.add("John 0");

        BowlingGame game = new BowlingGame();
        list.forEach((item) -> {
            String[] nameAndPins = item.split(" ");
            try {
                game.play(nameAndPins[0], nameAndPins[1]);
            } catch (GameException e) {
                Assert.fail(e.getMessage());
            }
        });

        try {
            Assert.assertEquals(TWO_PLAYER_EXPECTED_RESPONSE, game.printPlayersScores());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
