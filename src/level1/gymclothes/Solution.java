package level1.gymclothes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        validateN(n);
        validateLost(n, lost);
        validateReserve(n, reserve);

        //여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        lostList.sort(Integer::compareTo);
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        reserveList.sort(Integer::compareTo);

        for (int i = 0; i < lostList.size(); i++) {
            Integer l = lostList.get(i);
            if(reserveList.contains(l)){
                reserveList.remove(reserveList.indexOf(l));
                lostList.remove(i);
                i--;
                continue;
            }
        }

        for (int i = 0; i < lostList.size(); i++) {
            Integer l = lostList.get(i);
            if (reserveList.contains(l - 1)) {
                reserveList.remove(reserveList.indexOf(l - 1));
                lostList.remove(i);
                i--;
                continue;
            }
            if (reserveList.contains(l + 1)) {
                reserveList.remove(reserveList.indexOf(l + 1));
                lostList.remove(i);
                i--;
                continue;
            }
        }

        int answer = n - lostList.size();
        return answer;
        //여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
    }

    // 전체 학생의 수는 2명 이상 30명 이하입니다.

    private void validateN(int n) {
        if (n < 2 || n > 30) {
            throw new RuntimeException();
        }
    }

    //체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    private void validateLost(int n, int[] lost) {
        if (lost.length < 1 || lost.length > n) {
            throw new RuntimeException();
        }
        if (Arrays.stream(lost).boxed().collect(Collectors.toSet()).size() != lost.length) {
            throw new RuntimeException();
        }
    }

    //여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    private void validateReserve(int n, int[] reserve) {
        if (reserve.length < 1 || reserve.length > n) {
            throw new RuntimeException();
        }
        if (Arrays.stream(reserve).boxed().collect(Collectors.toSet()).size() != reserve.length) {
            throw new RuntimeException();
        }
    }
}