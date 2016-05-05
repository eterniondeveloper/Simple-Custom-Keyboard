package com.raptis.konstantinos.simplecustomkeyboard.core;

import com.raptis.konstantinos.simplecustomkeyboard.util.KeyObject;

import java.util.Arrays;

public class Buffer {
	
	private final int BUFFER_SIZE;
	private int index = 0;
	private KeyObject[] bufferArray;
	private KeyObject current;
	private KeyObject previous;
	
	public Buffer(int size) {
		BUFFER_SIZE = size;
		bufferArray = new KeyObject[size];
	}
	
	public void add(KeyObject keyObject) {
		if (current == null && previous == null) {
			current = keyObject;
		} else {
			previous = current;
			current = keyObject;
		}
		
		if (index >= BUFFER_SIZE) {
			//char last = buffer[index - 1];
			bufferArray = new KeyObject[BUFFER_SIZE];
            index = 0;
            //buffer[index++] = last;
        }
		bufferArray[index] = keyObject;
        index++;
    }
	
	public KeyObject getCurrent() {
		return current;
	}
	
	public KeyObject getPrevious() {
		return previous;
	}
	
	public int getSize() {
		return BUFFER_SIZE;
	}
	 
	public String display() {
		return Arrays.toString(bufferArray);
	}
	
}
