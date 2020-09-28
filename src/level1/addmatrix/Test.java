package level1.addmatrix;

public class Test {
    public static void main(String[] args) {
        int[][] result1 = new Solution().solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}});
        int[][] result2 = new Solution().solution(new int[][]{{1}, {2}}, new int[][]{{3}, {4}});

        for (int re[] : result1) {
            for (int r : re) {
                System.out.print(r + " ");
            }
        }
        System.out.println();
        for (int re[] : result2) {
            for (int r : re) {
                System.out.print(r + " ");
            }
        }
    }
}
