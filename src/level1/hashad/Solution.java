package level1.hashad;

// https://programmers.co.kr/learn/courses/30/lessons/12947?language=java
public class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        if (x % 자리수합(x) == 0) {
            answer = true;
        }
        return answer;
    }

    private int 자리수합(int n) {
        validateNumber(n);
        int add = 0;
        while (n > 0) {
            add += n % 10;
            n /= 10;
        }
        return add;
    }

    // x는 1 이상, 10000 이하인 정수입니다.
    private void validateNumber(int n) {
        if (n < 1 || n > 10000) {
            throw new RuntimeException();
        }
    }
}