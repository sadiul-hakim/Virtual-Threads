package org.javase;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureLearn {
    public static void main(String[] args) {

        Supplier<TaskResult> task1 = () -> FuturesPlay.doSomething("task1", 3, false);
        Supplier<TaskResult> task2 = () -> FuturesPlay.doSomething("task2", 2, false);
        try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
            CompletableFuture.supplyAsync(task1, service)
                    .thenCombine(CompletableFuture.supplyAsync(task2, service), (r1, r2) -> "Combined(" + r1.name() + " , " + r2.name() + ")")
                    .thenCompose(taskResult -> CompletableFuture.supplyAsync(() -> taskResult + " :: Handle Compose", service))
                    .exceptionally(throwable -> "")
                    .thenApply(data -> data + ":: Handle Apply")
                    .thenAccept(System.out::println)
                    .join();
        }
    }
}
