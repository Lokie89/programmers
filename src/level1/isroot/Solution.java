package level1.isroot;

// https://programmers.co.kr/learn/courses/30/lessons/12934?language=java
public class Solution {
    public long solution(long n) {
        long answer = -1;

        double root = Math.sqrt(n);
        if (root % 1 == 0) {
            answer = (long) Math.pow(root + 1, 2);
        }
        return answer;
    }

    // n은 1이상, 50000000000000 이하인 양의 정수입니다.
    private void validateNumber(long number) {
        if (number < 1 || number > 50000000000000L) {
            throw new RuntimeException();
        }
    }
}