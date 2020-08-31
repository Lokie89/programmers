package level1.sumbetweeninteger;

// https://programmers.co.kr/learn/courses/30/lessons/12912?language=java
public class Solution {
    public long solution(int a, int b) {
        // a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
        if (a == b) {
            return a;
        }

        long answer = 0;

        // a와 b의 대소관계는 정해져있지 않습니다.
        // swap
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = a; i <= b; i++) {
            answer += i;
        }

        return answer;
    }

    // a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
    private static void validateNumber(int number) {
        if (number < -10000000 || number > 10000000) {
            throw new RuntimeException();
        }
    }
}
