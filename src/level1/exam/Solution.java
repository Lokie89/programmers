package level1.exam;

public class Solution {
    public int solution(String p, String s) {
        validatePwdLength(p);
        validatePwdLength(s);
        validatePwdSameLength(p, s);
        final int pwdLength = s.length();
        int answer = 0;

        for (int i = 0; i < pwdLength; i++) {
            answer += getDiffer(p, s, i);
        }

        return answer;
    }

    private int getDiffer(String p, String s, int i) {
        int pInt = parsingStr(p.substring(i, i + 1));
        int sInt = parsingStr(s.substring(i, i + 1));
        int diff1 = diff(pInt, sInt);
        int diff2 = diff2(pInt, sInt);
        if (isSameOrOverNumber(diff1, diff2)) {
            return diff2;
        }
        return diff1;
    }

    private int diff(int number1, int number2) {
        if (isSameOrOverNumber(number1, number2)) {
            return number1 - number2;
        }
        return number2 - number1;
    }

    private int diff2(int number1, int number2) {
        if (isSameOrOverNumber(number1, number2)) {
            return number2 + 10 - number1;
        }
        return number1 + 10 - number2;
    }


    private boolean isSameOrOverNumber(int number, int compareNumber) {
        return number >= compareNumber;
    }

    private void validatePwdLength(String s) {
        final int validatePwdLength = 1000;
        if (isOverNumber(s.length(), validatePwdLength)) {
            throw new RuntimeException();
        }
    }

    private void validatePwdSameLength(String p, String s) {
        if (!isSameNumber(p.length(), s.length())) {
            throw new RuntimeException();
        }
    }

    private boolean isOverNumber(int number, int compareNumber) {
        return number > compareNumber;
    }

    private boolean isSameNumber(int number1, int number2) {
        return number1 == number2;
    }

    private int parsingStr(String s) {
        int parsingInt;
        try {
            parsingInt = Integer.parseInt(s);
            return parsingInt;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
