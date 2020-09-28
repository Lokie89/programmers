package level1.collatz;

// https://programmers.co.kr/learn/courses/30/lessons/12943
public class Solution {
    int count = 0;

    public int solution(int num) {
        if (count == 0) {
            validateNumber(num);
        }
        if (num == 1) {
            return count;
        }
        if (num < 0) {
            return -1;
        }
        if (num % 2 == 0) {
            num /= 2;
        } else {
            num = num * 3 + 1;
        }
        count++;

        if (count > 500) {
            return -1;
        }
        return solution(num);
    }

    // 입력된 수, num은 1 이상 8000000 미만인 정수입니다.
    private void validateNumber(int num) {
        if (num < 1 || num > 8000000) {
            throw new RuntimeException();
        }
    }
}