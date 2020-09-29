package level1.failpercent;

import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/42889?language=java
public class Solution {
    public int[] solution(int N, int[] stages) {
        validateN(N);
        validateStages(stages);

        Double[][] result = new Double[N][2];
        double total = stages.length;
        for (int i = 0; i < N; i++) {
            Double[] re = new Double[2];
            int finalI = i;
            re[0] = Double.valueOf(i+1);
            double count =
                    (double) Arrays.stream(stages)
                            .filter(value -> value == finalI + 1)
                            .count();
            re[1] = count / total;
            if(total==0){
                re[1] = -1.0;
            }
            result[i] = re;
            total = total - count;
        }
        Comparator<Double[]> comparator = Comparator.comparingDouble(o -> o[1]);
        int[] answer = Arrays.stream(result)
                .sorted(comparator.reversed())
                .mapToInt(value -> value[0].intValue()).toArray();
        return answer;
    }

    // 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
    void validateN(int N) {
        if (N < 1 || N > 500) {
            throw new RuntimeException();
        }
    }

    // stages의 길이는 1 이상 200,000 이하이다.
    void validateStages(int[] stages) {
        if (stages.length < 1 || stages.length > 200000) {
            throw new RuntimeException();
        }
    }

    // stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
    void validateStageNumber(int N, int stageNumber) {
        if (stageNumber < 1 || stageNumber > N + 1) {
            throw new RuntimeException();
        }
    }
}