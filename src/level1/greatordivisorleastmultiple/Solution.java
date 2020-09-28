package level1.greatordivisorleastmultiple;

import java.math.BigInteger;

// https://programmers.co.kr/learn/courses/30/lessons/12940?language=java
// https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95
public class Solution {
    public int[] solution(int n, int m) {
        validateNumber(n);
        validateNumber(m);
        BigInteger nBigInteger = BigInteger.valueOf(n);
        BigInteger mBigInteger = BigInteger.valueOf(m);

        int gcd = nBigInteger.gcd(mBigInteger).intValue();
        int[] answer = new int[]{
                gcd, (m * n) / gcd
        };
        return answer;
    }

    // 두 수는 1이상 1000000이하의 자연수입니다.
    private void validateNumber(int n) {
        if (n < 1 || n > 1000000) {
            throw new RuntimeException();
        }
    }
}