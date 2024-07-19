package algorithm;

import java.util.HashSet;
import java.util.Set;

public class SmallestNonOccurringInteger {
    public static int findSmallestNonOccurringInteger(int[] arr) {
        Set<Integer> positiveNumbers = new HashSet<>();

        for (int num : arr) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        int smallestNonOccurring = 1;
        while (positiveNumbers.contains(smallestNonOccurring)) {
            smallestNonOccurring++;
        }

        return smallestNonOccurring;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};

        System.out.println("Smallest non-occurring integer in Array1: " + findSmallestNonOccurringInteger(array1));
        System.out.println("Smallest non-occurring integer in Array2: " + findSmallestNonOccurringInteger(array2));
    }
}

