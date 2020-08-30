package level1.mockexam;

// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
// fail
public class Solution {

    static final int[] FIRST_CHALLENGER = new int[]{1, 2, 3, 4, 5};
    static final int[] SECOND_CHALLENGER = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] THIRD_CHALLENGER = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


    public int[] solution(int[] answers) {
        if (answers.length > 10000) {
            throw new RuntimeException();
        }
        int[] answer = {};
        int[] answerCount = new int[]{0, 0, 0};
        int fIndex = 0;
        int sIndex = 0;
        int tIndex = 0;
        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            if (ans < 1 || ans > 5) {
                throw new RuntimeException();
            }
            if (isOverBound(FIRST_CHALLENGER, fIndex)) {
                fIndex = 0;
            }
            if (isAnswer(ans, FIRST_CHALLENGER[fIndex])) {
                answerCount[0]++;
            }

            if (isOverBound(SECOND_CHALLENGER, sIndex)) {
                sIndex = 0;
            }
            if (isAnswer(ans, SECOND_CHALLENGER[sIndex])) {
                answerCount[1]++;
            }

            if (isOverBound(THIRD_CHALLENGER, tIndex)) {
                tIndex = 0;
            }
            if (isAnswer(ans, THIRD_CHALLENGER[tIndex])) {
                answerCount[2]++;
            }
            fIndex++;
            sIndex++;
            tIndex++;
        }
        int max = 0;
        for (int i = 0; i < answerCount.length; i++) {
            if (max < answerCount[i]) {
                max = answerCount[i];
            }
        }
        for (int i = 0; i < answerCount.length; i++) {
            if (max == answerCount[i]) {
                int size = answer.length;
                int[] tempArray = answer.clone();
                answer = new int[size + 1];
                moveArray(tempArray, answer);
                answer[i] = i + 1;
            }
        }

        for (int a : answer) {
            System.out.println(a);
        }

        return answer;
    }

    private void moveArray(int[] smallArray, int[] bigArray) {
        for (int i = 0; i < smallArray.length; i++) {
            bigArray[i] = smallArray[i];
        }
    }


    private boolean isOverBound(int[] array, int index) {
        return array.length <= index;
    }

    private boolean isAnswer(int answer, int challenger) {
        return answer == challenger;
    }
}