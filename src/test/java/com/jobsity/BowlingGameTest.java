package com.jobsity;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.interfaces.dict.EntryEnum;
import com.jobsity.models.BowlingGame;
import org.junit.Assert;
import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void testingCorrectProcessEntry(){
        BowlingGame game = new BowlingGame();

        try {
            //Testing main entries
            Assert.assertEquals(EntryEnum.FOUL,game.processEntry("F"));
            Assert.assertEquals(EntryEnum.ZERO,game.processEntry("0"));
            Assert.assertEquals(EntryEnum.ONE,game.processEntry("1"));
            Assert.assertEquals(EntryEnum.TWO,game.processEntry("2"));
            Assert.assertEquals(EntryEnum.THREE,game.processEntry("3"));
            Assert.assertEquals(EntryEnum.FOUR,game.processEntry("4"));
            Assert.assertEquals(EntryEnum.FIVE,game.processEntry("5"));
            Assert.assertEquals(EntryEnum.SIX,game.processEntry("6"));
            Assert.assertEquals(EntryEnum.SEVEN,game.processEntry("7"));
            Assert.assertEquals(EntryEnum.EIGHT,game.processEntry("8"));
            Assert.assertEquals(EntryEnum.NINE,game.processEntry("9"));
            Assert.assertEquals(EntryEnum.STRIKE,game.processEntry("10"));
        } catch (InvalidEntryException e) {
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void testingWrongProcessEntry(){
        BowlingGame game = new BowlingGame();

        //Testing not allowed entries
        try {
            //Testing main entries
            game.processEntry("-1");
        } catch (InvalidEntryException e) {
            Assert.assertEquals("Entry value -1 is not allowed", e.getMessage());
        }

        try {
            //Testing main entries
            game.processEntry("11");
        } catch (InvalidEntryException e) {
            Assert.assertEquals("Entry value 11 is not allowed", e.getMessage());
        }


    }
}
