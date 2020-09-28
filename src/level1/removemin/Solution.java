package level1.removemin;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr) {
        validateArrLength(arr);
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyArr);
        int min = copyArr[0];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int a : arr) {
            if (a != min) {
                arrayList.add(a);
            }
        }
        int[] answer = arrayList.stream().mapToInt(value -> value).toArray();
        if (answer.length == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    // arr은 길이 1 이상인 배열입니다.
    private void validateArrLength(int[] arr) {
        if (arr.length < 1) {
            throw new RuntimeException();
        }
    }
    // 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다. 중복이 없다?
}