package DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        List<Integer> q1 = new ArrayList<>();
        q1.add(63);
        q1.add(72);
        q1.add(83);
        q1.add(72);
        q1.add(54);

        function(q1, 72);
        function(q1, 83);
        function(q1, 49);
    }

    private static List<Integer> function(List<Integer> numberList, int findNumber) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            if (numberList.get(i) == findNumber) {
                result.add(i);
            }
        }

        List<Integer> collect = numberList.stream().sorted().collect(Collectors.toList());
        System.out.println("collect = " + collect);

        if (result.isEmpty()) {
            result.add(-1);
        }
        System.out.println("result = " + result);
        return result;
    }
}
