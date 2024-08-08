package org.example.day58;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            exe.submit( ()->{
                System.out.println("Running task " +taskNumber +" on thread "  + Thread.currentThread().getName() );
                    }

            );
        }
        exe.shutdown();
    }

}
