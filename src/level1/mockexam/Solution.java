package level1.mockexam;

public class Solution {

    private int firstMathAnswerCount = 0;
    private int secondMathAnswerCount= 0;
    private int thirdMathAnswerCount = 0;

    private final int[] firstMathAnswerRoutine = {1, 2, 3, 4, 5};
    private final int[] secondMathAnswerRoutine = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] thirdMathAnswerRoutine = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        validateExamLength(answers);

        int[] answer = {};
        return answer;
    }

    private void validateExamLength(int[] answers) {
        if (isIntegerLengthOver(answers, 10000)) {
            throw new RuntimeException();
        }
    }

    private void validateAnswer(int answer) {
        if (isIntegerUnder(answer, 1)) {
            throw new RuntimeException();
        }
        if (isIntegerOver(answer, 5)) {
            throw new RuntimeException();
        }
    }

    private boolean isIntegerLengthOver(int[] answers, int length) {
        return answers.length > length;
    }

    private boolean isIntegerOver(int answer, int number) {
        return answer > number;
    }

    private boolean isIntegerUnder(int answer, int number) {
        return answer < number;
    }
}
