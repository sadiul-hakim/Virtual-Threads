package org.javase;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class HttpPlay {
    private static final Logger LOGGER = Logger.getLogger(HttpPlay.class.getName());
    private static final int NUM_USERS = 1;

    public static void main(String[] args) {
        var factory = Thread.ofVirtual().name("request-handler-", 0).factory();
        CopyOnWriteArraySet<Future<String>> set = new CopyOnWriteArraySet<>();
        try (ExecutorService service = Executors.newThreadPerTaskExecutor(factory)) {
            IntStream.rangeClosed(1, NUM_USERS).forEach(num -> {
                try {
                    var future = service.submit(new UserRequestHandler());
                    set.add(future);
                } catch (Exception ex) {
                    LOGGER.log(Level.INFO, ex.getMessage());
                }
            });
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }

        System.out.printf("RESULT :: %s\n", set.size());
    }
}
