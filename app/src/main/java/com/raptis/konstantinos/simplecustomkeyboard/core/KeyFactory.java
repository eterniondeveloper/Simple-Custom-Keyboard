package com.raptis.konstantinos.simplecustomkeyboard.core;

import com.raptis.konstantinos.simplecustomkeyboard.util.Key;
import com.raptis.konstantinos.simplecustomkeyboard.util.DigraphType;
import com.raptis.konstantinos.simplecustomkeyboard.util.KeyObject;
import com.raptis.konstantinos.simplecustomkeyboard.util.Orientation;

/**
 * Created by konstantinos on 17/4/2016.
 */
public class KeyFactory {

    // keyboard layout
    public static String chars = "1234567890qwertyuiopasdfghjkl#↑zxcvbnm.?,/";

    // keys primary code mapping
    public static Key[][] keys = {{Key.ONE_BUTTON, Key.TWO_BUTTON, Key.THREE_BUTTON, Key.FOUR_BUTTON, Key.FIVE_BUTTON, Key.SIX_BUTTON, Key.SEVEN_BUTTON, Key.EIGHT_BUTTON, Key.NINE_BUTTON, Key.ZERO_BUTTON},
            {Key.Q_BUTTON, Key.W_BUTTON, Key.E_BUTTON, Key.R_BUTTON, Key.T_BUTTON, Key.Y_BUTTON, Key.U_BUTTON, Key.I_BUTTON, Key.O_BUTTON, Key.P_BUTTON},
            {Key.A_BUTTON, Key.S_BUTTON, Key.D_BUTTON, Key.F_BUTTON, Key.G_BUTTON, Key.H_BUTTON, Key.J_BUTTON, Key.K_BUTTON, Key.L_BUTTON, Key.SHARP_BUTTON},
            {Key.CAPS_LOCK_BUTTON, Key.Z_BUTTON, Key.X_BUTTON, Key.C_BUTTON, Key.V_BUTTON, Key.B_BUTTON, Key.N_BUTTON, Key.M_BUTTON, Key.FULL_STOP_BUTTON, Key.QUESTION_MARK_BUTTON},
            {Key.COMMA_BUTTON, Key.SLASH_BUTTON, Key.SPACE_BUTTON, Key.DELETE_BUTTON, Key.DONE_BUTTON}};

    // @Param : key which adjacent we want
    // @return : adjacent as a String
    public static String getNeighborsKeys(char key) {
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
    private static boolean areNeighbors(char c1, char c2) {
        char[] neighbors = getNeighborsKeys(c1).toCharArray();
        for(char c : neighbors) {
            if(c == c2) {
                return true;
            }
        }
        return false;
    }

    // @Param : c1 , c2 are the names of the two keys we ant to check if those keys are Horizontal or Vertical neighbors or non - neighbors
    // @return : custom enum type orientation (HORIZONTAL / VERTICAL)
    public static DigraphType getKeysOrientation(char c1, char c2) {
        return null;
    }

    // @Param : keyObject is the key we want to examine its digraph type
    // @return : keyObject digraph type
    public static DigraphType getDigraphType(KeyObject keyObject) {
        if(keyObject.getPrevious() == null) {
            return DigraphType.NULL;
        }
        // current with it's previous
        boolean areAdjacent = areNeighbors(keyObject.getKeyChar(), keyObject.getPrevious().getKeyChar());
        Orientation orientation = getOrientation(keyObject);

        if(areAdjacent && (orientation == Orientation.HORIZONTAL)) {
            return DigraphType.ADJACENT_HORIZONTAL_DIGRAPH;
        } else if(areAdjacent && (orientation == Orientation.VERTICAL)) {
            return DigraphType.ADJACENT_VERTICAL_DIGRAPH;
        } else if((!areAdjacent) && (orientation == Orientation.HORIZONTAL)) {
            return DigraphType.NON_ADJACENT_HORIZONTAL_DIGRAPH;
        } else if((!areAdjacent) && (orientation == Orientation.VERTICAL)) {
            return DigraphType.NON_ADJACENT_VERTICAL_DIGRAPH;
        } else {
            return DigraphType.NULL;
        }
    }

    // @Param : keyObject with its previous
    // @return : orientation
    private static Orientation getOrientation(KeyObject keyObject) {
        KeyObject previous = keyObject.getPrevious();
        int currentRow = KeyHandler.keysMap.get(keyObject.getPrimaryCode()).getRow();
        int currentColumn = KeyHandler.keysMap.get(keyObject.getPrimaryCode()).getColumn();
        int previousRow = KeyHandler.keysMap.get(previous.getPrimaryCode()).getRow();
        int previousColumn = KeyHandler.keysMap.get(previous.getPrimaryCode()).getColumn();

        if(currentRow == previousRow) {
            return Orientation.HORIZONTAL;
        } else if(currentColumn == previousColumn) {
            return Orientation.VERTICAL;
        } else {
            return Orientation.NULL;
        }
    }

}
