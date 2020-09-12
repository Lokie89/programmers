package level1.findprimenumber;

// https://programmers.co.kr/learn/courses/30/lessons/12921?language=java

// 참고
// https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4

import java.util.ArrayList;

public class Solution {

    public int solution(int n) {
        validateNumber(n);
//        allNumbers.add(2);
//        for (int i = 3; i <= n; i+=2) {
//            allNumbers.add(i);
//        }
//        for (int i = 0; i < allNumbers.size(); i++) {
//            int num = allNumbers.get(i);
//            for (int j = i + 1; j < allNumbers.size(); j++) {
//                if (allNumbers.get(j) % num == 0) {
//                    allNumbers.remove(j);
//                    j--;
//                }
//            }
//        }
//        return allNumbers.size();
        // ArrayList로 구현
        ArrayList<Boolean> primeList;
        int count = 0;

        // n+1만큼 할당
        primeList = new ArrayList<Boolean>(n + 1);
        // 0번째와 1번째를 소수 아님으로 처리
        primeList.add(false);
        primeList.add(false);
        // 2~ n 까지 소수로 설정
        for (int i = 2; i <= n; i++)
            primeList.add(i, true);

        // 2 부터  ~ i*i <= n
        // 각각의 배수들을 지워간다.
        for (int i = 2; (i * i) <= n; i++) {
            if (primeList.get(i)) {
                for (int j = i * i; j <= n; j += i) primeList.set(j, false);
                //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
            }
        }
        return (int) primeList.stream().filter(aBoolean -> aBoolean == Boolean.TRUE).count();
    }

    // n은 2이상 1000000이하의 자연수입니다.
    private void validateNumber(int n) {
        if (n < 2 || n > 1000000) {
            throw new RuntimeException();
        }
    }
}

