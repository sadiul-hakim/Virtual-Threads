package org.javase;

import java.util.concurrent.TimeUnit;

public class FuturesPlay {
    public static TaskResult doSomething(String name, int sec, boolean fail) {

        System.out.printf("%s is started\n", name);

        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (fail) {
            throw new RuntimeException();
        }

        System.out.printf("%s is completed\n", name);
        return new TaskResult(name,sec);
    }
}
