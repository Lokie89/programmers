package level1.budget;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12982?language=java
// TODO
public class Solution {
    public int solution(int[] d, int budget) {
        validateArrayLength(d);
        validateBudget(budget);
        Arrays.sort(d);
        int answer = 0;
        for (int i = 0; i < d.length; i++) {
            int apply = d[i];
            validateApply(apply);
            if (budget < apply) {
                break;
            }
            budget -= apply;
            answer++;
        }

        return answer;
    }

    // d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
    private void validateArrayLength(int[] arr) {
        if (arr.length < 1 || arr.length > 100) {
            throw new RuntimeException();
        }
    }

    // d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
    private void validateApply(int apply) {
        if (apply < 1 || apply > 100000) {
            throw new RuntimeException();
        }
    }

    private void validateBudget(int budget) {
        if (budget < 1 || budget > 10000000) {
            throw new RuntimeException();
        }
    }
    // budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
}