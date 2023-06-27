package de.dhbwka.java.exercise.threads.buffer;

public class ProducerThread extends Thread{
    MyBuffer buf;
    public ProducerThread(MyBuffer b) {
        this.buf = b;
    }
    public void run() {
        this.buf.put(5);
        this.buf.put(6);
        this.buf.put(34);
        this.buf.put(3523);
        this.buf.put(33);
        this.buf.put(22);
        this.buf.put(634324);


    }
}
