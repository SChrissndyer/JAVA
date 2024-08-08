package org.example.day58;

public class ConcurrencyDemo {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        Thread evenThread = new EvenNumberThread(printer);
        Thread oddThread = new OddNumberThread(printer);
        oddThread.start();
        evenThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted during join!");
        }

        System.out.println("Main thread ends.");
    }
}
