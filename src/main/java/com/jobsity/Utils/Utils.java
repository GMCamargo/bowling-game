package com.jobsity.Utils;

public class Utils {

    public static boolean isBlank(String s){
        if (s == null) return true;
        else return s.isEmpty() || s.equals(" ");
    }
}
