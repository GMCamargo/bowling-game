package com.jobsity;

import com.jobsity.exceptions.InvalidEntryException;
import com.jobsity.exceptions.InvalidRoundException;
import com.jobsity.interfaces.Round;
import com.jobsity.interfaces.dict.EntryEnum;
import com.jobsity.models.BowlingRound;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BowlingRoundTest {

    //testing marks convertion
    @Test
    public void testingMarksInRound() {
        BowlingRound round = new BowlingRound();
        try {
            //testing foul mark
            round.registryPlay(EntryEnum.FOUL);
            round.registryPlay(EntryEnum.ZERO);
            Assert.assertEquals("F\t0\t" ,round.getAllPlays());

            //testing strike mark
            round = new BowlingRound();
            round.registryPlay(EntryEnum.STRIKE);
            Assert.assertEquals("X\t", round.getAllPlays());

            //testing spare mark
            round = new BowlingRound();
            round.registryPlay(EntryEnum.ONE);
            round.registryPlay(EntryEnum.NINE);
            Assert.assertEquals("1\t/\t", round.getAllPlays());


        }catch (InvalidEntryException e){
            Assert.fail(e.getMessage());
        }
    }


    //Testing invalid round value
    @Test
    public void testingInvalidRound(){


        try {
            BowlingRound round = new BowlingRound();
            //value greater then 10
            round.registryPlay(EntryEnum.FIVE);
            round.registryPlay(EntryEnum.SIX);
            round.getDownedPins(0);
        }catch (InvalidRoundException e){
            Assert.assertEquals("Invalid value entry in round 0", e.getMessage());
        }catch (InvalidEntryException e) {
            Assert.fail(e.getMessage());
        }

        try {
            BowlingRound round = new BowlingRound();
            //value greater then 10
            round.registryPlay(EntryEnum.FIVE);
            round.registryPlay(EntryEnum.SIX);
            round.getDownedPins(0);
        }catch (InvalidRoundException e){
            Assert.assertEquals("Invalid value entry in round 0", e.getMessage());
        }catch (InvalidEntryException e) {
            Assert.fail(e.getMessage());
        }

        try {
            BowlingRound round = new BowlingRound();
            //value greater then 10
            round.registryPlay(EntryEnum.STRIKE);
            round.registryPlay(EntryEnum.ONE);
            round.getDownedPins(0);
        }catch (InvalidRoundException e){
            Assert.assertEquals("Invalid value entry in round 0", e.getMessage());
        }catch (InvalidEntryException e) {
            Assert.fail(e.getMessage());
        }

    }
}
