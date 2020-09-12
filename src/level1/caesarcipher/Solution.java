package level1.caesarcipher;

// https://programmers.co.kr/learn/courses/30/lessons/12926?language=java
public class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(move(c, n));
        }
        return sb.toString();
    }

    // s의 길이는 8000이하입니다.
    private void validateStrLength(String s) {
        if (s.length() < 1 || s.length() > 8000) {
            throw new RuntimeException();
        }
    }

    // n은 1 이상, 25이하인 자연수입니다.
    private void validateNumber(int n) {
        if (n < 1 || n > 25) {
            throw new RuntimeException();
        }

    }

    private char move(char c, int n) {
        // 공백은 아무리 밀어도 공백입니다.
        if (c == ' ') {
            return c;
        }
        n += c;
        if (65 <= c && c <= 90) {
            while (n > 90) {
                n -= 26;
            }
        } else {
            while (n > 122) {
                n -= 26;
            }
        }
        return (char) n;
    }
}
// s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
