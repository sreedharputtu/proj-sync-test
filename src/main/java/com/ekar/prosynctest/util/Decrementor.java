package com.ekar.prosynctest.util;

/**
 * Thread which decreases counter value by 1
 */
public class Decrementor extends Thread {
    private Counter counter;

    public Decrementor(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        while (true) {
            counter.decrease();
            try {
                this.sleep(1000);
            } catch (Exception e) {

            }
        }

    }
}
