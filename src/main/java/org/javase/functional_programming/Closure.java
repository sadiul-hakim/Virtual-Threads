package org.javase.functional_programming;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Closure is when child function (lamda) has its parents variable access even after the parent is returned.
 * In this case, 2 Counters has access to count variable and when i call their count method they give me 1 instead
 * of 3. They have their own count variable that is not shared among them.
 */

public class Closure {
    public static void main(String[] args) {
        Counter counter1 = counter();
        Counter counter2 = counter();
        Counter counter3 = counter();

        System.out.println(counter1.count());
        System.out.println(counter1.count());
        System.out.println(counter2.count());
        System.out.println(counter3.count());
    }

    static Counter counter() {
        AtomicInteger count = new AtomicInteger(0);
        return count::incrementAndGet;
    }
}
