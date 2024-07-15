package org.javase.structuredConcurrency;

import java.time.Duration;
import java.util.concurrent.Callable;

public class LongRunningTask implements Callable<TaskResponse> {
    private final String name;
    private final int time;
    private final String response;
    private final boolean fail;

    public LongRunningTask(String name, int sec, String response, boolean fail) {
        this.name = name;
        this.time = sec;
        this.response = response;
        this.fail = fail;
    }

    @Override
    public TaskResponse call() {

        System.out.println(name + " :: started");

        int index = 0;
        while (index++ < time) {

            if (Thread.interrupted()) {
                System.out.println(name + " :: interrupted");
                throw new RuntimeException(name + " :: interrupted");
            }

            System.out.println("working.. " + index);

            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch (InterruptedException ex) {
                System.out.println(name + " :: interrupted");
                throw new RuntimeException(ex);
            }
        }

        if (fail) {
            System.out.println(name + " :: Failed");
            throw new RuntimeException(name + " :: Failed");
        }

        System.out.println(name + " :: completed");

        return new TaskResponse(response);
    }
}