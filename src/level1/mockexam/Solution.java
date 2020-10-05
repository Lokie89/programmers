package level1.mockexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
public class Solution {

    static final int[] FIRST_CHALLENGER = new int[]{1, 2, 3, 4, 5};
    static final int[] SECOND_CHALLENGER = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] THIRD_CHALLENGER = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


    public int[] solution(int[] answers) {
        int fIndex = 0;
        int sIndex = 0;
        int tIndex = 0;

        int[] answerCount = new int[]{0, 0, 0};

        validateAnswerLength(answers);
        for (int ans : answers) {
            validateAnswer(ans);

            if (FIRST_CHALLENGER.length == fIndex) {
                fIndex = 0;
            }
            if (SECOND_CHALLENGER.length == sIndex) {
                sIndex = 0;
            }
            if (THIRD_CHALLENGER.length == tIndex) {
                tIndex = 0;
            }
            if (FIRST_CHALLENGER[fIndex] == ans) {
                answerCount[0]++;
            }

            if (SECOND_CHALLENGER[sIndex] == ans) {
                answerCount[1]++;
            }

            if (THIRD_CHALLENGER[tIndex] == ans) {
                answerCount[2]++;
            }
            fIndex++;
            sIndex++;
            tIndex++;
        }

        int max = Arrays.stream(answerCount).max().getAsInt();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < answerCount.length; i++) {
            if (answerCount[i] == max) {
                integers.add(i + 1);
            }
        }

        //가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
        integers.sort(Integer::compareTo);
        return integers.stream().mapToInt(value -> value).toArray();
    }

    // 시험은 최대 10,000 문제로 구성되어있습니다.
    private void validateAnswerLength(int[] answers) {
        if (answers.length > 10000) {
            throw new RuntimeException();
        }
    }

    //문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    private void validateAnswer(int answer) {
        if (answer < 1 || answer > 5) {
            throw new RuntimeException();
        }
    }

}