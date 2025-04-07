package org.javase;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class WorkingWithMemory {
    public static void main(String[] args) {
        // Create an arena to manage memory segments
        try (Arena arena = Arena.ofConfined()) {
            // Allocate a memory segment of size 4 bytes (int size)
            MemorySegment segment = arena.allocate(ValueLayout.JAVA_INT);

            // Write an integer value to the memory segment
            segment.set(ValueLayout.JAVA_INT, 0, 42);

            // Read the integer value from the memory segment
            int value = segment.get(ValueLayout.JAVA_INT, 0);

            System.out.println("Value from MemorySegment: " + value);
        }
        // Memory is automatically released when the arena is closed
    }

    static void withArray() {
        int arraySize = 5;

        try (Arena arena = Arena.ofConfined()) {
            // Allocate memory for an array of 5 integers
            MemorySegment segment = arena.allocate(arraySize * ValueLayout.JAVA_INT.byteSize());

            // Write values to the memory segment
            for (int i = 0; i < arraySize; i++) {
                segment.set(ValueLayout.JAVA_INT, i * ValueLayout.JAVA_INT.byteSize(), i + 1);
            }

            // Read values from the memory segment
            for (int i = 0; i < arraySize; i++) {
                int value = segment.get(ValueLayout.JAVA_INT, i * ValueLayout.JAVA_INT.byteSize());
                System.out.println("Value at index " + i + ": " + value);
            }
        }
    }
}
