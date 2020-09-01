package level1.cleardividednumberarray;

public class Test {
    public static void main(String[] args) {
        final int[] arr = new int[]{
                5, 9, 7, 10
        };
        final int divisor = 5;
        final int[] arr2 = new int[]{
                2, 36, 1, 3
        };
        final int divisor2 = 1;
        final int[] arr3 = new int[]{
                3, 2, 6
        };
        final int divisor3 = 10;

        int[] ans = new Solution().solution(arr, divisor);
        int[] ans2 = new Solution().solution(arr2, divisor2);
        int[] ans3 = new Solution().solution(arr3, divisor3);

        for(int a : ans){
            System.out.print(a+" ");
        }
        System.out.println();
        for(int a : ans2){
            System.out.print(a+" ");
        }
        System.out.println();
        for(int a : ans3){
            System.out.print(a+" ");
        }
    }
}
