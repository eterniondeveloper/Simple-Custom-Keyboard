package com.raptis.konstantinos.simplecustomkeyboard.util;

import com.raptis.konstantinos.simplecustomkeyboard.core.KeyHandler;

/**
 * Created by konstantinos on 17/4/2016.
 */
public class KeyObject {

    // field variables
    private int primaryCode;
    private Character keyChar;
    private double digraphTime;
    private long keyPressedTime;
    private long keyReleasedTime;
    private DigraphType digraphType;

    // constructor
    public KeyObject(int primaryCode, double digraphTime, long keyPressedTime, long keyReleasedTime) {
        this.primaryCode = primaryCode;
        this.digraphTime = digraphTime;
        this.keyPressedTime = keyPressedTime;
        this.keyReleasedTime = keyReleasedTime;
        keyChar = KeyHandler.keysMap.get(primaryCode).getKeyChar();
    }

    public char getKeyChar() {
        return keyChar;
    }

    // time passed from previous (if exist) key pressing
    public double getDigraphTime() {
        return digraphTime;
    }

    // get key hold time (ms)
    public double getHoldTime() {
        return (keyReleasedTime - keyPressedTime) / 1000000;
    }

    public int getPrimaryCode() {
        return primaryCode;
    }

    public void setKeyChar(char keyChar) {
        this.keyChar = keyChar;
    }

    public void setDigraphType(DigraphType digraphType) {
        this.digraphType = digraphType;
    }

    public DigraphType getDigraphType() {
        return digraphType;
    }

    // to String
    @Override
    public String toString() {
        /*if (KeyHandler.index - 2 < 0) {
            return String.format("Current: %2c; Previous: %2c; Digraph Time: %7s ms; Hold Time: %7.0f ms; Digraph Type: %-1s", keyChar, '-', '-', getHoldTime(), digraphType.toString());
        } else {
            return String.format("Current: %2c; Previous: %2c; Digraph Time: %7.0f ms; Hold Time: %7.0f ms; Digraph Type: %-1s", keyChar, KeyHandler.buffer[KeyHandler.index - 2].getKeyChar(), digraphTime, getHoldTime(), digraphType.toString());
        }*/
        return String.format("Current: %2c; Digraph Time: %7.0f ms; Hold Time: %7.0f ms; Digraph Type: %-1s", keyChar, digraphTime, getHoldTime(), digraphType.toString());
    }

}
