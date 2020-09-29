package level1.secretmap;

public class Test {
    public static void main(String[] args) {
        String[] result = new Solution().solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        for (String r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
        String[] result2 = new Solution().solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});
        for (String r : result2) {
            System.out.print(r + " ");
        }
    }
}
