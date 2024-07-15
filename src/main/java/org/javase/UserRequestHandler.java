package org.javase;

import java.net.URISyntaxException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRequestHandler implements Callable<String> {
    @Override
    public String call() throws Exception {
        try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
            return CompletableFuture.supplyAsync(this::dbCall1, service)
                    .thenCompose(res -> CompletableFuture.supplyAsync(this::dbCall2, service))
                    .thenCompose(res -> CompletableFuture.supplyAsync(this::restCall1, service)
                            .thenCombine(CompletableFuture.supplyAsync(this::restCall2, service), (r1, r2) -> {
                                return "";
                            }))
                    .thenApply(res -> res)
                    .join();
        }
    }

    private String dbCall1() {
        NetworkCaller caller = new NetworkCaller("DB");
        try {
            return caller.makeCall(2);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String dbCall2() {
        NetworkCaller caller = new NetworkCaller("DB");
        try {
            return caller.makeCall(3);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String restCall1() {
        NetworkCaller caller = new NetworkCaller("REST");
        try {
            return caller.makeCall(4);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String restCall2() {
        NetworkCaller caller = new NetworkCaller("REST");
        try {
            return caller.makeCall(5);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
