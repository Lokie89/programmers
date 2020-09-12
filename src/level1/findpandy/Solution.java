package level1.findpandy;

// https://programmers.co.kr/learn/courses/30/lessons/12916?language=java
public class Solution {
    boolean solution(String s) {
        validateStringLength(s);
        int pCount = 0;
        int yCount = 0;

        for (char c : s.toCharArray()) {
            validateChar(c);
            if(c=='p'||c=='P') {
                pCount++;
            }
            if(c=='y'||c=='Y') {
                yCount++;
            }
        }
        return pCount == yCount;
    }

    // 문자열 s의 길이 : 50 이하의 자연수
    private void validateStringLength(String s) {
        if (s.length() > 50) {
            throw new RuntimeException();
        }
    }

    // 문자열 s는 알파벳으로만 이루어져 있습니다.
    private void validateChar(char c) {
        if (!((65 <= c && c <= 90) || (97 <= c && c <= 122))) {
            throw new RuntimeException();
        }
    }
}

