package level1.addmatrix;

// https://programmers.co.kr/learn/courses/30/lessons/12950?language=java
public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        validateArr(arr1);
        validateArr(arr2);

        final int length = arr1.length;
        final int inLength = arr1[0].length;

        int[][] answer = new int[length][inLength];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < inLength; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }


    // 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
    private void validateArr(int[][] arr) {
        if (arr.length > 500) {
            throw new RuntimeException();
        }
    }

    private void validateArr2(int[] arr) {
        if (arr.length > 500) {
            throw new RuntimeException();
        }
    }

}