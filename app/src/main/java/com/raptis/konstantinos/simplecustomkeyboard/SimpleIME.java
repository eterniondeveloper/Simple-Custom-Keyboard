package com.raptis.konstantinos.simplecustomkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import com.raptis.konstantinos.simplecustomkeyboard.core.KeyHandler;
import com.raptis.konstantinos.simplecustomkeyboard.util.Helper;

import java.util.List;

/**
 * Created by konstantinos on 17/4/2016.
 */
public class SimpleIME extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener {

    // keyboard
    private KeyboardView kv;
    private Keyboard keyboard;
    private boolean caps = false;
    // key handler
    private KeyHandler keyHandler = new KeyHandler();
    private EditorInfo info;

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        playClick(primaryCode);
        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);

                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SHIFT_LEFT));
                break;
            case Keyboard.KEYCODE_DONE:
                //ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                switch (info.imeOptions & (EditorInfo.IME_MASK_ACTION | EditorInfo.IME_FLAG_NO_ENTER_ACTION)) {
                    case EditorInfo.IME_ACTION_NEXT:
                        ic.performEditorAction(EditorInfo.IME_ACTION_NEXT);
                        break;
                    case EditorInfo.IME_ACTION_DONE:
                        ic.performEditorAction(EditorInfo.IME_ACTION_DONE);
                        break;
                    default:
                        ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                        break;
                }
                break;
            default:
                char code = (char) primaryCode;
                if (Character.isLetter(code) && caps) {
                    code = Character.toUpperCase(code);
                }
                ic.commitText(String.valueOf(code), 1);
        }
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {
        this.info = info;

        List<Keyboard.Key> keys = keyboard.getKeys();

        switch (info.imeOptions & (EditorInfo.IME_MASK_ACTION | EditorInfo.IME_FLAG_NO_ENTER_ACTION)) {
            case EditorInfo.IME_ACTION_NEXT:
                Log.i(Helper.SWIPE_LOG, "IME_ACTION_NEXT");
                kv.invalidateAllKeys();
                keys.get(keys.size() - 1).label = "NEXT";
                break;
            case EditorInfo.IME_ACTION_DONE:
                Log.i(Helper.SWIPE_LOG, "KEYCODE_DONE");
                kv.invalidateAllKeys();
                keys.get(keys.size() - 1).label = "DONE";
                break;
            default:
                Log.i(Helper.SWIPE_LOG, "DEFAULT");
                break;
        }

        super.onStartInputView(info, restarting);
    }

    @Override
    public void onPress(int primaryCode) {
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, primaryCode));
        keyHandler.keyPressed(primaryCode);
    }

    @Override
    public void onRelease(int primaryCode) {
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, primaryCode));
        keyHandler.keyReleased(primaryCode);
    }

    @Override
    public void onText(CharSequence text) {
        Log.i(Helper.SWIPE_LOG, "onText");
    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeUp() {

    }

    @Override
    public View onCreateInputView() {
        kv = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        /*kv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i(Helper.TEST_LOG, "size: " + motionEvent.getSize() + "");
                return false;
            }
        });*/
        return kv;
    }

    private void playClick(int keyCode) {
        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        switch (keyCode) {
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case Keyboard.KEYCODE_DONE:
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
        }
    }

}
