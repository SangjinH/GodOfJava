package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Sort {


    public static void main(String[] args) {
        List<Integer> numberList = RandomNumberListUtils.getRandomNumber(4, 1000000);

        long start = System.currentTimeMillis();
        Collections.sort(numberList);
        long end = System.currentTimeMillis();
        System.out.println("java Collection Sort Time = " + (end - start));

        start = System.currentTimeMillis();
        List<Integer> sortedNumberList = mergeSort(numberList);
        end = System.currentTimeMillis();
        System.out.println("구현한 Merge Sort Time = " + (end - start));

        for (int i = 0; i < numberList.size(); i++) {
            if (!Objects.equals(numberList.get(i), sortedNumberList.get(i))) {
                throw new RuntimeException();
            }
        }
    }

    private static List<Integer> mergeSort(List<Integer> numberList) {
        if (numberList.size() <= 1) return numberList;

        int divIndex = Math.floorDiv(numberList.size(), 2);

        List<Integer> result = new ArrayList<>();

        List<Integer> leftList = mergeSort(numberList.subList(0, divIndex));
        List<Integer> rightList = mergeSort(numberList.subList(divIndex, numberList.size()));

        int leftCount = 0;
        int rightCount = 0;

        while (leftCount < leftList.size() || rightCount < rightList.size()) {

            Integer left = null;
            Integer right = null;
            if (leftCount < leftList.size()) {
                left = leftList.get(leftCount);
            }
            if (rightCount < rightList.size()) {
                right = rightList.get(rightCount);
            }

            if (left != null && right != null) {
                if (left <= right) {
                    result.add(leftList.get(leftCount));
                    leftCount += 1;
                } else {
                    result.add(rightList.get(rightCount));
                    rightCount += 1;
                }
            } else if (left == null) {
                result.add(rightList.get(rightCount));
                rightCount += 1;
            } else {
                result.add(leftList.get(leftCount));
                leftCount += 1;
            }
        }
        return result;
    }
}
