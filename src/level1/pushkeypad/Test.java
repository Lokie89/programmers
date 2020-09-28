package level1.pushkeypad;

public class Test {
    public static void main(String[] args) {
        final int[] numbers1 = new int[]{
                1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
        };
        final int[] numbers2 = new int[]{
                7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2
        };
        final int[] numbers3 = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 0
        };
        System.out.println(new Solution().solution(numbers1,"right"));
        System.out.println(new Solution().solution(numbers2,"left"));
        System.out.println(new Solution().solution(numbers3,"right"));
    }
}
