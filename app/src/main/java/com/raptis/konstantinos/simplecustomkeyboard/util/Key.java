package com.raptis.konstantinos.simplecustomkeyboard.util;

/**
 * Created by konstantinos on 17/4/2016.
 */
public enum Key {

    // Line 1
    ONE_BUTTON('1', 49, 0, 0), TWO_BUTTON('2', 50, 0, 1), THREE_BUTTON('3', 51, 0, 2), FOUR_BUTTON('4', 52, 0, 3),
    FIVE_BUTTON('5', 53, 0, 4), SIX_BUTTON('6', 54, 0, 5), SEVEN_BUTTON('7', 55, 0, 6), EIGHT_BUTTON('8', 56, 0, 7),
    NINE_BUTTON('9', 57, 0, 8), ZERO_BUTTON('0', 48, 0, 9),

    // Line 2
    Q_BUTTON('q', 113, 1, 0), W_BUTTON('w', 119, 1, 1), E_BUTTON('e', 101, 1, 2), R_BUTTON('r', 114, 1, 3),
    T_BUTTON('t', 116, 1, 4), Y_BUTTON('y', 121, 1, 5), U_BUTTON('u', 117, 1, 6), I_BUTTON('i', 105, 1, 7),
    O_BUTTON('o', 111, 1, 8), P_BUTTON('p', 112, 1, 9),

    // Line 3
    A_BUTTON('a', 97, 2, 0), S_BUTTON('s', 115, 2, 1), D_BUTTON('d', 100, 2, 2), F_BUTTON('f', 102, 2, 3),
    G_BUTTON('g', 103,2 , 4), H_BUTTON('h', 104, 2, 5), J_BUTTON('j', 106, 2, 6), K_BUTTON('k', 107, 2, 7),
    L_BUTTON('l', 108, 2, 8), SHARP_BUTTON('#', 35, 2, 9),

    // Line 4
    CAPS_LOCK_BUTTON('↑', -1, 3, 0), Z_BUTTON('z', 122, 3, 1), X_BUTTON('x', 120, 3, 2), C_BUTTON('c', 99, 3, 3),
    V_BUTTON('v', 118, 3, 4), B_BUTTON('b', 98, 3, 5), N_BUTTON('n', 110, 3, 6), M_BUTTON('m', 109, 3, 7),
    FULL_STOP_BUTTON('.', 46, 3, 8), QUESTION_MARK_BUTTON('?', 63, 3, 9),

    // Line 5
    COMMA_BUTTON(',', 44, 4, 0), SLASH_BUTTON('/', 47, 4, 1), SPACE_BUTTON(' ', 32, 4, 2), DELETE_BUTTON('←', -5, 4, 3),
    DONE_BUTTON('→', -4, 4, 4);

    private char keyChar;
    private int primaryCode;
    private int row;
    private int column;

    Key(char keyChar, int primaryCode, int row, int column) {
        this.keyChar = keyChar;
        this.primaryCode = primaryCode;
        this.row = row;
        this.column = column;
    }

    public char getKeyChar() {
        return keyChar;
    }

    public int getPrimaryCode() {
        return primaryCode;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
