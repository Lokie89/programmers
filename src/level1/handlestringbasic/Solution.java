package level1.handlestringbasic;

// https://programmers.co.kr/learn/courses/30/lessons/12918?language=java
public class Solution {
    public boolean solution(String s) {
        validateStrLength(s);
        final int strLength = s.length();
        boolean answer = (strLength==4 || strLength==6) &&
                strLength ==s.chars().filter(value -> value >= 48 && value <= 57).count();
        return answer;
    }

    // s는 길이 1 이상, 길이 8 이하인 문자열입니다.
    private void validateStrLength(String s) {
        if (s.length() < 1 || s.length() > 8) {
            throw new RuntimeException();
        }

    }
}

