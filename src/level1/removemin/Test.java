package level1.removemin;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = new int[]{
                4, 3, 2, 1
        };
        int[] arr2 = new int[]{
                10
        };
        int[] result1 = new Solution().solution(arr1);
        int[] result2 = new Solution().solution(arr2);

        for (int r : result1) {
            System.out.print(r + " ");
        }
        System.out.println();
        for (int r : result2) {
            System.out.print(r + " ");
        }
    }
}
