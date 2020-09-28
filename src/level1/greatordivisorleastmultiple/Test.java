package level1.greatordivisorleastmultiple;

public class Test {
    public static void main(String[] args) {
        int[] result = new Solution().solution(3, 12);
        int[] result2 = new Solution().solution(2, 5);
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
        for (int r : result2) {
            System.out.print(r + " ");
        }
    }
}
