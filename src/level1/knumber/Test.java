package level1.knumber;

public class Test {
    public static void main(String[] args) {
        final int[] array = new int[]{
                1, 5, 2, 6, 3, 7, 4
        };
        final int[][] commands = new int[][]{
                {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
        };
        int[] ret = new Solution().solution(array, commands);
        for (int r : ret) {
            System.out.print(r + " ");
        }
    }
}
