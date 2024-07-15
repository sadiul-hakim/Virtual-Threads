package org.javase.structuredConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var task = new LongRunningTask("LongRunningTask", 10, "simple-response", false);
        try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
            var future = service.submit(task);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Main :: waiting done");
//            future.cancel(true);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main :: completed");
    }
}
