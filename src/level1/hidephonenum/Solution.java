package level1.hidephonenum;

// https://programmers.co.kr/learn/courses/30/lessons/12948
public class Solution {
    public String solution(String phone_number) {
        validateLength(phone_number);
        int length = phone_number.length();

        String answer = "";
        for (int i = 0; i < length - 4; i++) {
            answer += "*";
        }
        answer += phone_number.substring(length - 4, length);
        return answer;
    }

    // s는 길이 4 이상, 20이하인 문자열입니다
    private void validateLength(String s) {
        if (s.length() < 4 || s.length() > 20) {
            throw new RuntimeException();
        }
    }
}