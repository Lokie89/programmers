package level2.developfunction;

import java.util.*;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        validateProgressSpeedLength(progresses);
        validateProgressSpeedLength(speeds);

        Queue<Integer> progressQue = new LinkedList<>(Arrays.stream(progresses).boxed().collect(Collectors.toList()));
        Queue<Integer> speedQue = new LinkedList<>(Arrays.stream(speeds).boxed().collect(Collectors.toList()));

        List<Integer> answerList = new ArrayList<>();
        while (progressQue.size() > 0) {
            int answer = 0;
            while (progressQue.peek() != null && progressQue.peek() >= 100) {
                progressQue.poll();
                speedQue.poll();
                answer++;
            }
            if (answer > 0) {
                answerList.add(answer);
            }
            progressQue = plus(progressQue, new LinkedList<>(speedQue));
        }
        return answerList.stream().mapToInt(value -> value).toArray();
        //배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
    }

    Queue<Integer> plus(Queue<Integer> progress, Queue<Integer> speed) {
        Queue<Integer> tempQue = new LinkedList<>();
        while (progress.peek() != null) {
            tempQue.add(progress.poll() + speed.poll());
        }
        return tempQue;
    }

    // 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
    void validateProgressSpeedLength(int[] progressesOrSpeeds) {
        if (progressesOrSpeeds.length > 100) {
            throw new RuntimeException();
        }
    }

    //작업 진도는 100 미만의 자연수입니다.
    void validateProgress(int progress) {
        if (progress < 1 || 100 < progress) {
            throw new RuntimeException();
        }
    }

    //작업 속도는 100 이하의 자연수입니다.
    void validateSpeed(int speed) {
        if (speed < 1 || 101 < speed) {
            throw new RuntimeException();
        }
    }

    // 정답
//    public int[] solution(int[] progresses, int[] speeds) {
//        int[] dayOfend = new int[100];
//        int day = -1;
//        for(int i=0; i<progresses.length; i++) {
//            while(progresses[i] + (day*speeds[i]) < 100) {
//                day++;
//            }
//            dayOfend[day]++;
//        }
//        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
//    }
}