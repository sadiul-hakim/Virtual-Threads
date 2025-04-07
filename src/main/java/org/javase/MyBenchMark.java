package org.javase;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) // Measure average execution time
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Results in milliseconds
@State(Scope.Thread) // Each thread gets its own instance
public class MyBenchMark {

    @Benchmark
    public int computeSum() {
        int sum = 0;
        for (int i = 0; i < 100_000_000; i++) {
            sum += i;
        }
        return sum;
    }
}
