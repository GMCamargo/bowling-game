package com.jobsity.interfaces.dict;

public enum EntryEnum {

    FOUL("F"),
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    STRIKE("10");

    private final int value;
    EntryEnum(String entry) {
        if (entry.equals("F"))
            value = 0;
        else value = Integer.parseInt(entry);
    }

    public int getValue(){
        return value;
    }

    public String getStringValue() {
        return String.valueOf(value);
    }
}
