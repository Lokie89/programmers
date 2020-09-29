package level1.termxnumbers;

public class Test {
    public static void main(String[] args) {
        long[] result1 = new Solution().solution(2, 5);
        long[] result2 = new Solution().solution(4, 3);
        long[] result3 = new Solution().solution(-4, 2);

        for (long r : result1) {
            System.out.print(r + " ");
        }
        System.out.println();
        for (long r : result2) {
            System.out.print(r + " ");
        }
        System.out.println();
        for (long r : result3) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
