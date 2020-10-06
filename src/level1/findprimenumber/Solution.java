package level1.findprimenumber;

// 참고
// https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/12921?language=java
// TODO
public class Solution {
    public int solution(int n) {
        validateN(n);

        int sqrt = (int) Math.sqrt(n);

        List<Boolean> total = new ArrayList<>();
        total.add(false);
        total.add(false);
        for (int i = 2; i <= n; i++) {
            total.add(true);
        }

        for (int i = 2; i <= sqrt; i++) {
            if (isPrimeNumber(i)) {
                for (int j = i + 1; j <= n; j++) {
                    if (j % i == 0) {
                        total.set(j, false);
                    }
                }
            }
        }

        int answer = (int) total.stream().filter(Boolean::booleanValue).count();
        return answer;
    }

//    public int solution(int n) {
//        validateN(n);
//        int sqrt = (int) Math.sqrt(n);
//
//        List<Integer> primes = new ArrayList<>();
//        for (int i = 2; i <= sqrt; i++) {
//            if (isPrimeNumber(i)) {
//                primes.add(i);
//            }
//        }
//        List<Integer> total = new ArrayList<>();
//        for (int i = 2; i <= n; i++) {
//            total.add(i);
//        }
//
//        return (int) total.stream()
//                .filter(t ->
//                        primes.stream()
//                                .filter(p -> t != p && t % p == 0)
//                                .count() == 0
//                )
//                .count();
//    }

    boolean isPrimeNumber(int n) {
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    // n은 2이상 1000000이하의 자연수입니다.
    private void validateN(int n) {
        if (n < 2 || n > 1000000) {
            throw new RuntimeException();
        }
    }
}