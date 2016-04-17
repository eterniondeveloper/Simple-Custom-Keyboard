package com.raptis.konstantinos.simplecustomkeyboard.core;

import com.raptis.konstantinos.simplecustomkeyboard.util.Orientation;

import java.util.Arrays;

/**
 * Created by konstantinos on 17/4/2016.
 */
public class KeyFactory {

    // keyboard layout
    public static String chars = "qwertyuiopasdfghjkl;zxcvbnm,.";

    // @Param : key which adjacent we want
    // @return : adjacent as a String
    public static String getNeighboringKeys(char key) {
        StringBuffer result = new StringBuffer();
        for (char c : chars.toCharArray()) {
            if (c != key && distance(c, key) < 2) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // @Param : c1 , c2 the two keys for which we want to calculate distance
    // @return : the distance as a double (primitive)
    private static double distance(char c1, char c2) {
        return Math.sqrt(Math.pow(colOf(c2) - colOf(c1), 2) + Math.pow(rowOf(c2) - rowOf(c1), 2));
    }

    private static int rowOf(char c) {
        return chars.indexOf(c) / 10;
    }

    private static int colOf(char c) {
        return chars.indexOf(c) % 10;
    }

    // @Param : c1 , c2 are the names of the two keys we want to check if those keys are neighbors
    // @return : true if they are neighbors, false if they aren't neighbors
    public static boolean areNeighbors(char c1, char c2) {
        char[] neighbors = getNeighboringKeys(c1).toCharArray();
        if (Arrays.asList(neighbors).contains(c2)) {
            return true;
        }
        return false;
    }

    // @Param : c1 , c2 are the names of the two keys we ant to check if those keys are Horizontal or Vertical neighbors or non - neighbors
    // @return : custom enum type orientation (HORIZONTAL / VERTICAL)
    public static Orientation getKeysOrientation(char c1, char c2) {
        return null;
    }

}
