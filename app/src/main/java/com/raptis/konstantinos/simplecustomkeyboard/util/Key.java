package com.raptis.konstantinos.simplecustomkeyboard.util;

import com.raptis.konstantinos.simplecustomkeyboard.core.KeyFactory;

import java.io.Serializable;

/**
 * Created by konstantinos on 17/4/2016.
 */
public class Key implements Serializable {

    // field variables
    private Key previous;
    private char name;
    private double digraphTime;
    private long keyPressedTime;
    private long keyReleasedTime;
    private int keyCode;
    private char[] adjacentKeysArray;

    // constructor
    public Key(char name, Key previous, double digraphTime, long keyPressedTime, long keyReleasedTime, int keyCode) {
        this.name = name;
        this.previous = previous;
        this.previous = previous;
        this.digraphTime = digraphTime;
        this.keyPressedTime = keyPressedTime;
        this.keyReleasedTime = keyReleasedTime;
        this.keyCode = keyCode;
        adjacentKeysArray = KeyFactory.getNeighboringKeys(name).toCharArray();
    }

    public Key getPrevious() {
        return previous;
    }

    public char getName() {
        return name;
    }

    // time passed from previous (if exist) key pressing
    public double getDigraphTime() {
        return digraphTime;
    }

    // get key hold time (ms)
    public double getHoldTime() {
        return (keyReleasedTime - keyPressedTime) / 1000000;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public char[] getAdjacentKeysArray() {
        return adjacentKeysArray;
    }

    public void setName(char name) {
        this.name = name;
    }

    // to String
    @Override
    public String toString() {
        if (previous == null) {
            return String.format("Current: %5c; Previous: %5c; Time Passed: %10s ms; Hold Time: %10.0f ms", name, '-', '-', getHoldTime());
        } else {
            return String.format("Current: %5c; Previous: %5c; Time Passed: %10.0f ms; Hold Time: %10.0f ms", name, previous.getName(), digraphTime, getHoldTime());
        }
    }

}
