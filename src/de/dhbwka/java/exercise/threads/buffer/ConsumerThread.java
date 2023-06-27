package de.dhbwka.java.exercise.threads.buffer;

public class ConsumerThread extends Thread{
    MyBuffer buffer;
    public ConsumerThread(MyBuffer b) {
        this.buffer = b;
    }
    public void run() {
        this.buffer.get(0);
    }
    public static void main(String[] args) {
        MyBuffer buf = new MyBuffer();
        ProducerThread thread1 = new ProducerThread(buf);
        thread1.start();
        ConsumerThread thread2 = new ConsumerThread(buf);
        thread2.start();
    }
}
