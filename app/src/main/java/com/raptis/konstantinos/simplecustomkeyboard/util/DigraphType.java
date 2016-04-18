package com.raptis.konstantinos.simplecustomkeyboard.util;

/**
 * Created by konstantinos on 17/4/2016.
 */

/*
 *  Adjacent Horizontal Digraph. This is the time elapsed between releasing a key and pressing the adjacent
 *  key in the horizontal line of keys, e.g. the time between key 1 and key 2, key 5 and key 6
 *
 *  Adjacent Vertical Digraph. This is the time elapsed between releasing a key and pressing the adjacent
 *  key in the vertical line of keys, e.g. the time between key 1 and key 4, key 5 and key 8
 *
 *  Non-Adjacent Horizontal Digraph. This is the time elapsed between releasing a key and pressing the next
 *  key in the horizontal line such that the keys are separated by another key, e.g. time between key 1 and key 3,
 *  key 4 and key 6
 *
 *  Non-Adjacent Vertical Digraph. This is the time elapsed between releasing a key and pressing the next
 *  key in the vertical line such that the keys are separated by another key, e.g. the time between key 1 and key 7,
 *  key 0 and key 5, key 3 and key 9
 */

public enum DigraphType {

    NULL(),
    ADJACENT_HORIZONTAL_DIGRAPH() ,
    ADJACENT_VERTICAL_DIGRAPH(),
    NON_ADJACENT_HORIZONTAL_DIGRAPH(),
    NON_ADJACENT_VERTICAL_DIGRAPH()

}
