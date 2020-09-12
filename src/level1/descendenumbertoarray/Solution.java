package level1.descendenumbertoarray;

// https://programmers.co.kr/learn/courses/30/lessons/12932?language=java

public class Solution {
    public int[] solution(long n) {
        int[] answer = new int[(int) Math.log10(n) + 1];
        int index = 0;
        while (n != 0) {
            answer[index++] = (int) (n % 10);
            n = n / 10;
        }
        return answer;
    }

    // n은 10,000,000,000이하인 자연수입니다.
    private void validateNumber(long n) {
        if (n < 1 || n > 10000000000L) {
            throw new RuntimeException();
        }
    }
}
