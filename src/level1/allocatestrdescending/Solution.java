package level1.allocatestrdescending;

import java.util.List;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/12917?language=java
public class Solution {
    public String solution(String s) {
        validateStrLength(s);
        List<Character> list = s.chars().mapToObj(value -> (char) value).sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }

        return sb.toString();
    }

    // str은 길이 1 이상인 문자열입니다.
    private void validateStrLength(String s) {
        if (s.length() < 1) {
            throw new RuntimeException();
        }
    }
}
