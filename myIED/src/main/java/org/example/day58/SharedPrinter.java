package org.example.day58;

class SharedPrinter {
    private boolean isEvenTurn = true;

    public synchronized void printEven(int number) {
        while (!isEvenTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Even: " + number);
        isEvenTurn = false;
        notifyAll();
    }

    public synchronized void printOdd(int number) {
        while (isEvenTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Odd: " + number);
        isEvenTurn = true;
        notifyAll();
    }
}
