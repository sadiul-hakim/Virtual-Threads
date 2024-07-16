package org.javase.structuredConcurrency;

import java.time.Duration;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.TimeUnit;

public class StructuredTaskScopeLearn {
    public static void main(String[] args) {
        System.out.println("Main :: Started");
//        interruptMainThread();
//        exampleCompleteAllTask();
//        exampleTerminalIfOneFail();
//        exampleTerminateOnSuccess();
        exampleCustomTaskScope();
        System.out.println("Main :: Exited");
    }

    private static void interruptMainThread() {
        Thread mainThread = Thread.currentThread();

        Thread.ofPlatform().start(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                mainThread.interrupt();
            } catch (Exception ignore) {
            }
        });
    }

    private static void exampleCompleteAllTask() {
        try (var scope = new StructuredTaskScope<TaskResponse>()) {
            var expTask = new LongRunningTask("expedia-task", 5, "100$", false);
            var hotTask = new LongRunningTask("hotwire-task", 10, "110$", false);

            var expSubtask = scope.fork(expTask);
            var hotSubtask = scope.fork(hotTask);

            if (true) {
                Thread.sleep(Duration.ofSeconds(2));
                throw new RuntimeException();
            }

//            scope.joinUntil(Instant.now().plus(Duration.ofSeconds(2)));
            scope.join();

            var expState = expSubtask.state();
            var hotState = hotSubtask.state();

            if (expState.equals(StructuredTaskScope.Subtask.State.SUCCESS)) {
                System.out.println(expSubtask.get());
            } else if (expState.equals(StructuredTaskScope.Subtask.State.FAILED)) {
                System.out.println(expSubtask.exception());
            }

            if (hotState.equals(StructuredTaskScope.Subtask.State.SUCCESS)) {
                System.out.println(hotSubtask.get());
            } else if (hotState.equals(StructuredTaskScope.Subtask.State.FAILED)) {
                System.out.println(hotSubtask.exception());
            }

        } catch (Exception ignore) {
        }
    }

    private static void exampleTerminalIfOneFail() {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var dataTask = new LongRunningTask("DataTask", 4, "row1", false);
            var restTask = new LongRunningTask("RestTask", 10, "json2", false);

            var dataSubTask = scope.fork(dataTask);
            var restSubTask = scope.fork(restTask);

//            if(true){
//                Thread.sleep(Duration.ofSeconds(2));
//                throw new RuntimeException();
//            }

            scope.join();
            scope.throwIfFailed();

            System.out.println(dataSubTask.get());
            System.out.println(restSubTask.get());

        } catch (Exception ignore) {
        }
    }

    private static void exampleTerminateOnSuccess() {
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<TaskResponse>()) {
            var dataTask = new LongRunningTask("weather-1", 4, "32", true);
            var restTask = new LongRunningTask("weather-2", 10, "33", false);

            var dataSubTask = scope.fork(dataTask);
            var restSubTask = scope.fork(restTask);

//            if(true){
//                Thread.sleep(Duration.ofSeconds(2));
//                throw new RuntimeException();
//            }

            scope.join();

            System.out.println(scope.result());

        } catch (Exception ignore) {
        }
    }

    private static void exampleCustomTaskScope() {
        try (var scope = new AverageWeatherTaskScope()) {
            var task1 = new LongRunningTask("weather-1", 4, "32", true);
            var task2 = new LongRunningTask("weather-2", 10, "33", false);
            var task3 = new LongRunningTask("weather-3", 2, "34", true);
            var task4 = new LongRunningTask("weather-4", 5, "31", true);

            scope.fork(task1);
            scope.fork(task2);
            scope.fork(task3);
            scope.fork(task4);

//            if(true){
//                Thread.sleep(Duration.ofSeconds(2));
//                throw new RuntimeException();
//            }

            scope.join();

            System.out.println(scope.response());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
