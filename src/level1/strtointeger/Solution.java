package level1.strtointeger;

public class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
    }

    //s의 길이는 1 이상 5이하입니다.
    private void validateStrLength(String s) {
        if (s.length() < 1 || s.length() > 5) {
            throw new RuntimeException();
        }
    }
}
//s의 맨앞에는 부호(+, -)가 올 수 있습니다.
//s는 부호와 숫자로만 이루어져있습니다.
//s는 0으로 시작하지 않습니다.