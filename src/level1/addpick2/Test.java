package level1.addpick2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{
                2, 1, 3, 4, 1
        };
        int[] numbers2 = new int[]{
                5, 0, 2, 7
        };
        int[] result1 = new Solution().solution(numbers1);
        int[] result2 = new Solution().solution(numbers2);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
