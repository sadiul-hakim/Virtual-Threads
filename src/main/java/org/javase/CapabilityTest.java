package org.javase;

import java.util.concurrent.TimeUnit;

public class CapabilityTest {
    public static void handleRequest(int num) {
        System.out.printf("handleRequest() :: %s start\n", num);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception ignore) {
        }

        System.out.printf("handleRequest() :: %s end\n", num);
    }

    public static void main(String[] args) {
        System.out.println("main() :: start");

        for (int i = 0; i < 50000; i++) {
            final int index = i + 1;

        }

        System.out.println("main() :: end");
    }
}
