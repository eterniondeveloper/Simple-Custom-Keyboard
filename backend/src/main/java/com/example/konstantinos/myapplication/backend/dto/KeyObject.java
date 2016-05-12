package com.example.konstantinos.myapplication.backend.dto;

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
    public KeyObject() {

    }

    // constructor
    public KeyObject(int primaryCode, Character keyChar, double digraphTime, long keyPressedTime, long keyReleasedTime) {
        this.primaryCode = primaryCode;
        this.keyChar = keyChar;
        this.digraphTime = digraphTime;
        this.keyPressedTime = keyPressedTime;
        this.keyReleasedTime = keyReleasedTime;
    }

    // setters

    public void setPrimaryCode(int primaryCode) {
        this.primaryCode = primaryCode;
    }

    public void setKeyChar(Character keyChar) {
        this.keyChar = keyChar;
    }

    public void setDigraphTime(double digraphTime) {
        this.digraphTime = digraphTime;
    }

    public void setKeyPressedTime(long keyPressedTime) {
        this.keyPressedTime = keyPressedTime;
    }

    public void setKeyReleasedTime(long keyReleasedTime) {
        this.keyReleasedTime = keyReleasedTime;
    }

    public void setDigraphType(DigraphType digraphType) {
        this.digraphType = digraphType;
    }


    // getters


    public int getPrimaryCode() {
        return primaryCode;
    }

    public Character getKeyChar() {
        return keyChar;
    }

    public long getKeyPressedTime() {
        return keyPressedTime;
    }

    public double getDigraphTime() {
        return digraphTime;
    }

    public long getKeyReleasedTime() {
        return keyReleasedTime;
    }

    public DigraphType getDigraphType() {
        return digraphType;
    }

    // get key hold time (ms)
    public double getHoldTime() {
        return (keyReleasedTime - keyPressedTime) / 1000000;
    }

    // to String
    @Override
    public String toString() {
        return String.format("Current: %2c; Digraph Time: %7.0f ms; Hold Time: %7.0f ms; Digraph Type: %-1s", keyChar, digraphTime, getHoldTime(), digraphType.toString());
    }

}

