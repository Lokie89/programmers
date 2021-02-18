package level2.scoville;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] scoville, int K) {
        validateScovilles(scoville);
        validateK(K);
        int answer = 0;
        Queue<Integer> scovilleQueue = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        while (isNotOverK(scovilleQueue, K)) {
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
            if (scovilleQueue.size() < 2) {
                return -1;
            }
            scovilleQueue = mixScoville(scovilleQueue);
            answer++;
        }

        return answer;
    }

    private boolean isNotOverK(Queue<Integer> scoville, int K) {
        return scoville.stream().anyMatch(sco -> sco < K);
    }

    private Queue<Integer> mixScoville(Queue<Integer> sortedQueue) {
        int mixScoville = sortedQueue.poll() + sortedQueue.poll() * 2;
        sortedQueue.add(mixScoville);
        return sortedQueue;
    }

    // scoville의 길이는 2 이상 1,000,000 이하입니다.
    private void validateScovilles(int[] scoville) {
        if (scoville.length < 2 || 1000000 < scoville.length) {
            throw new RuntimeException();
        }
        for (int sco : scoville) {
            validateScoville(sco);
        }
    }

    // K는 0 이상 1,000,000,000 이하입니다.
    private void validateK(int K) {
        if (K < 0 || 1000000000 < K) {
            throw new RuntimeException();
        }
    }

    // scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
    private void validateScoville(int scoville) {
        if (scoville < 0 || 1000000 < scoville) {
            throw new RuntimeException();
        }
    }
}
