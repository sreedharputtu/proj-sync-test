package com.ekar.prosynctest.util;

import java.util.stream.IntStream;

/**
 * Thread which inrements counter value by 1
 */
public class Incrementor extends Thread {

    private Counter counter;

    public Incrementor(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        while (true) {
            counter.Increase();
            try {
                this.sleep(1500);
            } catch (Exception e) {

            }
        }
    }

}
