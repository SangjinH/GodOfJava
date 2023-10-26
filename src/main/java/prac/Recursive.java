package prac;

import java.awt.desktop.AboutEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Recursive {

    public static void main(String[] args) {

        int targetNumber = 12;

        int fibonacciRecursive = fibonacciRecursive(targetNumber);
        System.out.println("targetNumber = " + targetNumber);
        System.out.println("fibonacciRecursive = " + fibonacciRecursive);

        int fibonacciIterative = fibonacciIterative(targetNumber);
        System.out.println("fibonacciIterative = " + fibonacciIterative);

        List<Integer> numberList = new ArrayList<>();
        Random random = new Random();
        int bound = 100000;
        int findNumber = random.nextInt(bound);

        for (int i = 0; i < 10000; i++) numberList.add(random.nextInt(bound));
        Collections.sort(numberList);

        System.out.println("numberList = " + numberList);
        System.out.println("findNumber = " + findNumber);
        int findNumberIndex = binarySearchByRecursive(numberList, findNumber, 0, numberList.size() - 1);
        System.out.println("findNumberIndex = " + findNumberIndex);

        for (int i = 0; i < numberList.size(); i++) {
            if (numberList.get(i) == findNumber) {
                System.out.println("realIndexNumber = " + i);
                break;
            }
        }
    }

    private static int fibonacciRecursive(int targetNumber) {
        if (targetNumber == 1) {
            return 1;
        } else if (targetNumber == 0) {
            return 0;
        } else {
            return fibonacciRecursive(targetNumber - 1) + fibonacciRecursive(targetNumber - 2);
        }
    }

    private static int fibonacciIterative(int targetNumber) {

        int a = 0;
        int b = 1;

        int cnt = 0;
        while (cnt < targetNumber) {
            cnt += 1;

            int tempA = b;
            int tempB = a + b;

            a = tempA;
            b = tempB;
        }

        return a;
    }

    /**
     * 이진탐색의 재귀버전 구현
     *
     * @param numberList   찾고자하는 숫자리스트, sort 되어있는 상태
     * @param targetNumber 찾고자하는 숫자
     * @param startIndex   시작 인덱스
     * @param endIndex     끝 인덱스
     * @return targetNumber 의 위치 인덱스
     */
    private static int binarySearchByRecursive(List<Integer> numberList, int targetNumber, int startIndex, int endIndex) {
        if (startIndex > endIndex) return -1;

        int midIndex = Math.floorDiv(startIndex + endIndex, 2);

        Integer midNumber = numberList.get(midIndex);
        if (midNumber == targetNumber) {
            return midIndex;
        } else if (midNumber < targetNumber) {
            startIndex = midIndex + 1;
            return binarySearchByRecursive(numberList, targetNumber, startIndex, endIndex);
        } else {
            endIndex = midIndex - 1;
            return binarySearchByRecursive(numberList, targetNumber, startIndex, endIndex);
        }
    }
}
