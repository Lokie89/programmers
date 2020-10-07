package level2.truckmovebridge;

import java.util.*;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42583?language=java
public class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        validateBridgeLength(bridge_length);
        validateWeight(weight);
        validateTruckWeightsLength(truck_weights);

        Queue<Integer> truckQue = new LinkedList<>(Arrays.stream(truck_weights).boxed().collect(Collectors.toList()));
        Queue<Integer> bridgeQue = new LinkedList<>();
        List<Integer> bridgeCount = new ArrayList<>();

        int answer = 0;
        while (truckQue.size() > 0 || bridgeCount.size() > 0) {
            if (truckQue.peek() != null
                    && bridgeQue.size() <= bridge_length
                    && bridgeQue.stream().mapToInt(value -> value).sum() + truckQue.peek() <= weight) {
                int truckWeight = truckQue.poll();
                validateTruckWeight(truckWeight, weight);
                bridgeQue.add(truckWeight);
                bridgeCount.add(bridge_length);
            }
            answer++;
            for (int i = 0; i < bridgeCount.size(); i++) {
                Integer count = bridgeCount.get(i);
                bridgeCount.set(i, count - 1);
                if (bridgeCount.get(i) == 0) {
                    bridgeCount.remove(i);
                    bridgeQue.poll();
                    i--;
                }
            }
        }

        return answer + 1;
    }

    // bridge_length는 1 이상 10,000 이하입니다.
    void validateBridgeLength(int bridgeLength) {
        if (bridgeLength < 1 || 10000 < bridgeLength) {
            throw new RuntimeException();
        }
    }

    //weight는 1 이상 10,000 이하입니다.
    void validateWeight(int weight) {
        if (weight < 1 || 10000 < weight) {
            throw new RuntimeException();
        }
    }

    //truck_weights의 길이는 1 이상 10,000 이하입니다.
    void validateTruckWeightsLength(int[] truckWeight) {
        if (truckWeight.length < 1 || 10000 < truckWeight.length) {
            throw new RuntimeException();
        }
    }

    //모든 트럭의 무게는 1 이상 weight 이하입니다.
    void validateTruckWeight(int truckWeight, int weight) {
        if (truckWeight < 1 || weight < truckWeight) {
            throw new RuntimeException();
        }
    }
}