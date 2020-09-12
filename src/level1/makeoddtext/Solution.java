package level1.makeoddtext;

// https://programmers.co.kr/learn/courses/30/lessons/12930?language=java

// s.split(" ", -1) 그냥하면 안되고 -1 붙여줘야 함 이유?
public class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : s.split(" ", -1)) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                c = i % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c);
                sb.append(c);
            }
            sb.append(" ");
        }
        String answer = sb.toString();
        return answer.substring(0, answer.length() - 1);
    }
}

// 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
// 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.