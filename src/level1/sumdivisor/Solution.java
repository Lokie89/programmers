package level1.sumdivisor;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }

    // n은 0 이상 3000이하인 정수입니다.
    private void validateNumber(int n) {
        if (n < 0 || n > 3000) {
            throw new RuntimeException();
        }
    }
}
