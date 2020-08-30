package level1.gymclothes;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42862
public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        validateTotalStudent(n);
        validateArrayStudent(lost, n);
        validateArrayStudent(reserve, n);
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int remain = n - lost.length;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length - 1; j++) {

                if (lost[i] - 1 == reserve[j]) {
                    remain++;
                    reserve[j] = 0;
                    break;
                }
                if (lost[i] + 1 == reserve[j + 1]) {
                    remain++;
                    reserve[j] = 0;
                    break;
                }
            }
        }
        int answer = remain;
        return answer;
    }
    // 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
    // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.


    // 전체 학생의 수는 2명 이상 30명 이하입니다.
    private void validateTotalStudent(int total) {
        if (total < 2 || total > 30) {
            throw new RuntimeException();
        }
    }

    // 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    // 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    private void validateArrayStudent(int[] array, int total) {
        final int arraySize = array.length;
        if (arraySize < 1 || arraySize > total) {
            throw new RuntimeException();
        }

        Set<Integer> lostSet = new HashSet<>();
        List<Integer> lostList = new ArrayList<>();
        for (int l : array) {
            lostList.add(l);
        }
        lostSet.addAll(lostList);
        if (arraySize != lostSet.size()) {
            throw new RuntimeException();
        }
    }
}
