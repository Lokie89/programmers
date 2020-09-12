package level1.addnumbers;

// https://programmers.co.kr/learn/courses/30/lessons/12931?language=java
public class Solution {
    public int solution(int n) {
        validateNumber(n);
        int pow = (int) Math.log10(n);
        int answer = 0;

        for (int i = pow; i >= 0; i--) {
            int powNum = (int) Math.pow(10, i);
            answer += n / powNum;
            n = n % powNum;
        }
        return answer;
    }

    private void validateNumber(int n) {
        if (n < 1 || n > 100000000) {
            throw new RuntimeException();
        }
    }
}
//N의 범위 : 100,000,000 이하의 자연수
