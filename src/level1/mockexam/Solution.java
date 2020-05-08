package level1.mockexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private final int[] firstMathAnswerRoutine = {1, 2, 3, 4, 5};
    private final int[] secondMathAnswerRoutine = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] thirdMathAnswerRoutine = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        validateExamLength(answers);

        final int firstAnswerCount = loopByRoutine(firstMathAnswerRoutine, answers);
        final int secondAnswerCount = loopByRoutine(secondMathAnswerRoutine, answers);
        final int thirdAnswerCount = loopByRoutine(thirdMathAnswerRoutine, answers);
        List<Integer> answerCountList = new ArrayList<>();

        answerCountList.add(firstAnswerCount);
        answerCountList.add(secondAnswerCount);
        answerCountList.add(thirdAnswerCount);

        Collections.sort(answerCountList,Collections.reverseOrder());

        int maxAnswerCount = answerCountList.get(0);
        answerCountList = answerCountList.stream().filter(integer -> maxAnswerCount == integer).collect(Collectors.toList());

        final int answerCountListSize = answerCountList.size();
        int[] answer = new int[answerCountListSize];
        for (int i = 0; i < answerCountListSize; i++) {
            answer[i] = answerCountList.get(i);
        }
        return answer;
    }

    private int loopByRoutine(int[] answerRoutine, int[] answers) {
        final int routineLength = answerRoutine.length;
        int equalCount = 0;
        final int answersLength = answers.length;
        for (int i = 0, j = 0; i < answersLength; i++, j++) {
            validateAnswer(answers[i]);
//            validateAnswer(answerRoutine[i]);
            if (j > routineLength) {
                j -= routineLength;
            }
            if (isSameNumber(answers[i], answerRoutine[j])) {
                equalCount++;
            }
        }
        return equalCount;
    }

    private boolean isSameNumber(int number1, int number2) {
        return number1 == number2;
    }

    private void validateExamLength(int[] answers) {
        final int maxExamLength = 10000;
        if (isIntegerLengthOver(answers, maxExamLength)) {
            throw new RuntimeException();
        }
    }


    private void validateAnswer(int answer) {
        final int minAnswer = 1;
        final int maxAnswer = 5;
        if (isOverNumber(minAnswer, answer)) {
            throw new RuntimeException();
        }
        if (isOverNumber(answer, maxAnswer)) {
            throw new RuntimeException();
        }
    }

    private boolean isIntegerLengthOver(int[] answers, int length) {
        return answers.length > length;
    }


    private boolean isOverNumber(int number, int compareNumber) {
        return number > compareNumber;
    }
}
