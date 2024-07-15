package org.javase;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyFutureTask<V> extends FutureTask<V> {
    public MyFutureTask(Callable<V> callable) {
        super(callable);
    }

    @Override
    protected void done() {
        try {
            System.out.println("Done task one...." + get());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
