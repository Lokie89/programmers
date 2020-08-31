package level1.knumber;

// https://programmers.co.kr/learn/courses/30/lessons/42748?language=java

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        validateArrayLength(array);
        validateCommandsLength(commands);
        int[] answer = new int[commands.length];
        int answerIndex = 0;
        for (int[] command : commands) {
            validateCommandLength(command);
            final int start = command[0] - 1;
            final int end = command[1];
            int[] copyArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(copyArray);
            final int index = command[2]-1;
            answer[answerIndex++] = copyArray[index];
        }
        return answer;
    }


    // array의 길이는 1 이상 100 이하입니다.
    private static void validateArrayLength(int[] array) {
        if (array.length < 1 || array.length > 100) {
            throw new RuntimeException();
        }
    }

    // array의 각 원소는 1 이상 100 이하입니다.
    private static void validateArrayNumber(int number) {
        if (number < 1 || number > 100) {
            throw new RuntimeException();
        }
    }

    // commands의 길이는 1 이상 50 이하입니다.
    private static void validateCommandsLength(int[][] commands) {
        if (commands.length < 1 || commands.length > 50) {
            throw new RuntimeException();
        }
    }

    // commands의 각 원소는 길이가 3입니다.
    private static void validateCommandLength(int[] command) {
        if (command.length != 3) {
            throw new RuntimeException();
        }
    }

}
