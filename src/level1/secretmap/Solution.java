package level1.secretmap;

// https://programmers.co.kr/learn/courses/30/lessons/17681?language=java
// TODO
public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        validateN(n);
        validateArray(n, arr1, arr2);
        String[] answer = new String[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            validateBinary(n, arr1[i]);
            validateBinary(n, arr2[i]);

            char[] arr1Char = fillZero(n, Integer.toBinaryString(arr1[i])).toCharArray();
            char[] arr2Char = fillZero(n, Integer.toBinaryString(arr2[i])).toCharArray();
            String sharp = "";
            for (int j = 0; j < arr1Char.length; j++) {
                if (arr1Char[j] == '0' && arr2Char[j] == '0') {
                    sharp += " ";
                } else {
                    sharp += "#";
                }
            }
            answer[i] = sharp;
        }
        return answer;
    }

    String fillZero(int n, String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() != n) {
            for (int i = 0; i < n - s.length(); i++) {
                sb.append("0");
            }
        }
        sb.append(s);
        return sb.toString();
    }

    // 1 ≦ n ≦ 16
    void validateN(int n) {
        if (n < 1 || n > 16) {
            throw new RuntimeException();
        }
    }

    // arr1, arr2는 길이 n인 정수 배열로 주어진다.
    void validateArray(int n, int[] arr1, int[] arr2) {
        if (arr1.length != n || arr2.length != n) {
            throw new RuntimeException();
        }
    }

    // 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
    void validateBinary(int n, int x) {
        if (Integer.toBinaryString(x).length() > n) {
            throw new RuntimeException();
        }
    }
}