package org.javase.algorithm;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        int index = BinarySearch.search(numbers, 5, 0, numbers.size() - 1);
        System.out.println(numbers.get(index));
    }
}
