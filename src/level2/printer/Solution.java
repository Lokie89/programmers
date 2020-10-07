package level2.printer;

import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
            index.add(i);
        }
        boolean isLocation = true;
        while (isLocation) {

            int max = 0;
            for (int i = 0; i < queue.size(); i++) {
                int queueNum = ((LinkedList<Integer>) queue).get(i);
                if (max < queueNum)
                    max = queueNum;
            }
            while (queue.size() > 0) {
                if (((LinkedList<Integer>) queue).getFirst() == max) {
                    queue.poll();
                    int loc = index.poll();
                    answer++;
                    if (loc == location)
                        isLocation = false;
                    break;
                } else {
                    int addInt = queue.poll();
                    queue.add(addInt);
                    int addIndex = index.poll();
                    index.add(addIndex);
                }
            }

        }
        return answer;
    }
}