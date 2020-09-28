package level1.addpick2;

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

        for (int r : result1) {
            System.out.print(r + " ");
        }
        System.out.println();
        for (int r : result2) {
            System.out.print(r + " ");
        }
    }
}
