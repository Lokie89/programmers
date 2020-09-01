package level1.sortstring;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12915?language=java
public class Solution {
    public String[] solution(String[] strings, int n) {
        validateArrayLength(strings);
        Arrays.stream(strings)
                .forEach(s -> validateString(s, n))
        ;
        Arrays.sort(strings);

        Arrays.sort(strings, (o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);
            return c1 - c2;
        });
        return strings;
    }

    // strings는 길이 1 이상, 50이하인 배열입니다.
    private static void validateArrayLength(String[] strings) {
        if (strings.length < 1 || strings.length > 50) {
            throw new RuntimeException();
        }
    }

    // strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
    // strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
    // 모든 strings의 원소의 길이는 n보다 큽니다.
    private static void validateString(String s, int n) {
        if ((s.length() < 1 || s.length() > 100) && s.length() > n) {
            throw new RuntimeException();
        }
        for (char c : s.toCharArray()) {
            if (c < 97 || c > 122) {
                throw new RuntimeException();
            }
        }
    }
}

