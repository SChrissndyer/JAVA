package org.example.day58;

class EvenNumberThread extends Thread {
    private final SharedPrinter printer;

    public EvenNumberThread(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i += 2) {
            printer.printEven(i);
            try {
                Thread.sleep(500); // Sleep for 0.5 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class OddNumberThread extends Thread {
    private final SharedPrinter printer;

    public OddNumberThread(SharedPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            printer.printOdd(i);
            try {
                Thread.sleep(500); // Sleep for 0.5 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
