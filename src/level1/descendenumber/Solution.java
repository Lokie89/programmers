package level1.descendenumber;

import java.util.Arrays;
import java.util.Collections;

// https://programmers.co.kr/learn/courses/30/lessons/12933?language=java
public class Solution {
    public long solution(long n) {
        validateN(n);
        String strN = String.valueOf(n);
        Character[] characters = strN.chars().mapToObj(value -> (char)value).toArray(Character[]::new);
        Arrays.sort(characters, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(char c: characters){
            sb.append(c);
        }
        long answer = Long.parseLong(sb.toString());
        return answer;
    }

    // n은 1이상 8000000000 이하인 자연수입니다.
    private void validateN(long n) {
        if (n < 1 || n > 8000000000L) {
            throw new RuntimeException();
        }
    }
}