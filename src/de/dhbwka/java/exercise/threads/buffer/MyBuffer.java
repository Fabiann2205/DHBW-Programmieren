package de.dhbwka.java.exercise.threads.buffer;

import java.util.ArrayList;
import java.util.List;

public class MyBuffer {
    private final List<Integer> value = new ArrayList<>();
    private boolean empty = true;

    // the producer routine
    public synchronized void put(int v) {
        if (!this.empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // buffer is empty, fill it!
        this.value.add(v);
        this.empty = false;
        // notify waiting consumer
        this.notify();
        System.out.println("Put: " + v);
    }

    // the consumer routine
    public synchronized int get(int element) {
        int v;
        if (this.empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // buffer is full, empty it!
        v = this.value.get(element);
        this.value.remove(element);
        this.empty = this.value.isEmpty();

        // notify waiting producer
        this.notify();
        System.out.println("Get:" + v);
        return v;
    }

    public static void main(String[] args) {
        MyBuffer buf = new MyBuffer();
        buf.put(5);
        buf.put(6);
        buf.get(5);
    }
}


