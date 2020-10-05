package level0.test;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public int[] solution(int[][] v) {
        validateArray2Length(v);
        List<Integer> integerListX = new ArrayList<>();
        List<Integer> integerListY = new ArrayList<>();

        for (int[] vArray : v) {
            validateArrayLength(vArray);
            int x = vArray[0];
            int y = vArray[1];
            validatePosition(x);
            validatePosition(y);
            if (integerListX.contains(x)) {
                integerListX.remove(Integer.valueOf(x));
            } else {
                integerListX.add(x);
            }
            if (integerListY.contains(y)) {
                integerListY.remove(Integer.valueOf(y));
            } else {
                integerListY.add(y);
            }
        }
        return new int[]{integerListX.get(0),integerListY.get(0)};
    }

    //v는 세 점의 좌표가 들어있는 2차원 배열입니다.
    private void validateArray2Length(int[][] v) {
        if (v.length != 3) {
            throw new RuntimeException();
        }
    }

    private void validateArrayLength(int[] vArray) {
        if (vArray.length != 2) {
            throw new RuntimeException();
        }
    }

    //좌표값은 1 이상 10억 이하의 자연수입니다.
    private void validatePosition(int position) {
        if (position < 1 || position > 1000000000) {
            throw new RuntimeException();
        }
    }


}
//v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
//직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.