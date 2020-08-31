package level1.middleword;

// https://programmers.co.kr/learn/courses/30/lessons/12903?language=java
public class Solution {
    public String solution(String s) {
        validateStringLength(s);
        String answer = "";
        int index = s.length() / 2;
        int remain = s.length() % 2;
        if (remain == 1) {
            answer = s.substring(index, index + 1);
        } else {
            answer = s.substring(index - 1, index + 1);
        }
        return answer;
    }

    // s는 길이가 1 이상, 100이하인 스트링입니다.
    private static void validateStringLength(String s) {
        if (s.length() < 1 || s.length() > 100) {
            throw new RuntimeException();
        }
    }
}

