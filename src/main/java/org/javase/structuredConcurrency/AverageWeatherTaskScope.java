package org.javase.structuredConcurrency;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.StructuredTaskScope;

public class AverageWeatherTaskScope extends StructuredTaskScope<TaskResponse> {
    private final CopyOnWriteArrayList<Subtask<? extends TaskResponse>> successfulTasks = new CopyOnWriteArrayList<>();

    @Override
    protected void handleComplete(Subtask<? extends TaskResponse> subtask) {
        if (subtask.state().equals(Subtask.State.SUCCESS))
            add(subtask);
    }

    private void add(Subtask<? extends TaskResponse> subtask) {
        successfulTasks.add(subtask);
        if (successfulTasks.size() == 2) {
            this.shutdown();
        }
    }

    @Override
    public AverageWeatherTaskScope join() throws InterruptedException {
        super.join();
        return this;
    }

    public TaskResponse response(){
        super.ensureOwnerAndJoined();
        if(successfulTasks.size() != 2)
            throw new RuntimeException("At least 2 tasks has to be successful");

        var task1 = successfulTasks.getFirst();
        var task2 = successfulTasks.getLast();

        double avg = Math.addExact(
                Integer.parseInt(task1.get().response()),
                Integer.parseInt(task2.get().response())
        ) / 2.0;

        return new TaskResponse("Weather-"+avg);
    }
}
