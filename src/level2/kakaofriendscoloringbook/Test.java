package level2.kakaofriendscoloringbook;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution().solution(6, 4,
                        new int[][]{
                                {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
                        }
                )
        ));
    }
}
