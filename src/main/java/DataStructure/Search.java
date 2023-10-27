package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.Math.floorMod;

public class Search {

    public static void main(String[] args) {

        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            numberList.add((int) (random() * 1000000));
        }

        Collections.sort(numberList);

//        System.out.println("numberList = " + numberList);

        int targetNumber = (int) (random() * 1000000);
        System.out.println("targetNumber = " + targetNumber);
        long startTime = System.currentTimeMillis();
        int binaryCount = binarySearchFunction(numberList, targetNumber);
        long endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - startTime));
        System.out.println("binaryCount = " + binaryCount);

        startTime = System.currentTimeMillis();
        int linearCount = linearSearchFunction(numberList, targetNumber);
        endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - startTime));
        System.out.println("linearCount = " + linearCount);

    }

    private static int binarySearchFunction(List<Integer> integerList, int targetNumber) {
        int count = 0;

        int start = 0;
        int end = integerList.size() - 1;
        while (start < end) {
            int mid = floorDiv((start + end), 2);
            count += 1;
            Integer medium = integerList.get(mid);
            System.out.println("medium = " + medium);
            if (medium == targetNumber) {
                break;
            } else if (medium < targetNumber) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return count;
    }

    private static int linearSearchFunction(List<Integer> integerList, int targetNumber) {
        int count = 0;

        for (int i = 0; i < integerList.size(); i++) {
            count += 1;
            if (integerList.get(i) == targetNumber) {
                break;
            }
        }
        return count;
    }
}
