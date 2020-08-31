package level1.hatesamenum;

public class Test {
    public static void main(String[] args) {
        final int[] arr = new int[]{
                1, 1, 3, 3, 0, 1, 1
        };
        final int[] arr2 = new int[]{
                4, 4, 4, 3, 3
        };

        int[] answer = new Solution().solution(arr);
        int[] answer2 = new Solution().solution(arr2);

        for (int a : answer) {
            System.out.print(a + " ");
        }
        for (int a : answer2) {
            System.out.print(a + " ");
        }
    }
}
