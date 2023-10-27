package DataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

public class RandomNumberListUtils {

    /**
     * digit 자리 수 이내의 무작위 숫자 배열을 리턴한다
     *
     * @param digit
     * @return
     */
    public static List<Integer> getRandomNumber(int digit, int count) {
        List<Integer> resultList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            resultList.add(random.nextInt((int) pow(10, digit)));
        }
        return resultList;
    }
}
