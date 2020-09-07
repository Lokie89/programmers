package level1.subak;

// https://programmers.co.kr/learn/courses/30/lessons/12922?language=java
public class Solution {
    public String solution(int n) {
        validateLength(n);
        final String subak = "수박";
        final String su = "수";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            sb.append(subak);
        }
        if (n % 2 == 1) {
            sb.append(su);
        }
        return sb.toString();
    }

    // n은 길이 10,000이하인 자연수입니다.
    private void validateLength(int n) {
        if (n < 1 || n > 10000) {
            throw new RuntimeException();
        }
    }
}

