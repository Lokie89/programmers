package level1.findkiminseoul;

// https://programmers.co.kr/learn/courses/30/lessons/12919?language=java
public class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer += i;
                break;
            }
        }
        answer += "에 있다";
        return answer;
    }

    // seoul은 길이 1 이상, 1000 이하인 배열입니다.
    private void arrayLength(String[] seoul) {
        if (seoul.length < 1 || seoul.length > 1000) {
            throw new RuntimeException();
        }
    }

    //seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
    private void strLength(String s) {
        if (s.length() < 1 || s.length() > 20) {
            throw new RuntimeException();
        }
    }
}
//Kim은 반드시 seoul 안에 포함되어 있습니다.