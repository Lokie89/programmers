package level1.termxnumbers;

// https://programmers.co.kr/learn/courses/30/lessons/12954?language=java
public class Solution {
    public long[] solution(int x, int n) {
        validateX(x);
        validateN(n);
        long[] answer = new long[n];
        long number = x;
        for (int i = 0; i < n; i++) {
            answer[i] = number;
            number += x;
        }
        return answer;
    }

    // x는 -10000000 이상, 10000000 이하인 정수입니다.
    private void validateX(int x) {
        if (x < -10000000 || x > 10000000) {
            throw new RuntimeException();
        }
    }

    // n은 1000 이하인 자연수입니다.
    private void validateN(int n) {
        if (n < 1 || n > 1000) {
            throw new RuntimeException();
        }
    }
}