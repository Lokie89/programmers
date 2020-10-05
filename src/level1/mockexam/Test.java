package level1.mockexam;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] solution1 = new Solution().solution(answer1);
        System.out.println(Arrays.toString(solution1));
        int[] answer2 = {1, 3, 2, 4, 2};
        int[] solution2 = new Solution().solution(answer2);
        System.out.println(Arrays.toString(solution2));
    }
}
