package com.raptis.konstantinos.simplecustomkeyboard.core;

import android.util.Log;
import android.view.KeyEvent;

import com.raptis.konstantinos.simplecustomkeyboard.util.Key;

/**
 * Created by konstantinos on 17/4/2016.
 */
public class KeyHandler {

    // logcat id
    public static final String CUSTOM_LOG = "cmlog";
    // variables
    public static final int BUFFER_SIZE = 15;
    private int index = 0;
    private Key[] buffer = new Key[BUFFER_SIZE];
    private int errorRateCounter = 0;

    public void add(Key key) {
        if(index >= BUFFER_SIZE) {
            buffer = new Key[BUFFER_SIZE];
            index = 0;
        }
        buffer[index] = key;
        index ++;

        // check if key code is 67 (backspace)
        if(key.getKeyCode() == 67) {
            key.setName('←');
            errorRateCounter++;
        }
    }

    // index always point to the first available position in buffer
    public int getIndex() {
        return index;
    }

    // get buffer
    public Key[] getBuffer() {
        return buffer;
    }

    // get error rate counter
    public int getErrorRateCounter() {
        return errorRateCounter;
    }

    // key pressed
    public void keyPressed(int primaryCode) {
        //Log.i(CUSTOM_LOG, KeyEvent.keyCodeToString(primaryCode));
    }

    // key released
    public void keyReleased(int primaryCode) {
        Log.i(CUSTOM_LOG, primaryCode + "");
    }

}
