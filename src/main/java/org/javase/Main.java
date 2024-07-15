package org.javase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        ThreadFactory factory = Thread.ofVirtual().name("JavaSE", 0).factory();

        try (ExecutorService service = Executors.newThreadPerTaskExecutor(factory)) {
            IntStream.rangeClosed(1, 10_000).forEach(i -> {
                service.submit(() -> System.out.println(Thread.currentThread()));
            });
        } catch (Exception ignore) {

        }


    }
}

 