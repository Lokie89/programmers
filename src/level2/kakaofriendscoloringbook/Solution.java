package level2.kakaofriendscoloringbook;

// https://programmers.co.kr/learn/courses/30/lessons/1829?language=java
// TODO
public class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        validateMN(m);
        validateMN(n);
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
        //picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
    }

    // 1 <= m, n <= 100
    void validateMN(int mOrN) {
        if (mOrN < 1 || 100 < mOrN) {
            throw new RuntimeException();
        }
    }

    //picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
    void validatePicture(int picture) {
        if (picture < 0) {
            throw new RuntimeException();
        }
    }
}