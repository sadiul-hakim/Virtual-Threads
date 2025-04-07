package org.javase.algorithm;

import java.util.List;

public class BinarySearch {
    public static int search(List<Integer> numbers, int number, int start, int end) {
        if (numbers.isEmpty())
            return -1;

        int mid = (start + end) / 2;
        if (numbers.get(mid) == number)
            return mid;

        if (numbers.get(mid) > number) {
            return search(numbers, number, start, mid);
        }
        if (numbers.get(mid) < number) {
            return search(numbers, number, mid - 1,end);
        }

        return -1;
    }
}
