package level0.test;


public class Test {
    public static void main(String[] args) {
        int[][] v = new int[][]{
                {1, 4}, {3, 4}, {3, 10}
        };
        int[] va = new Solution().solution(v);

        for(int a:va){
            System.out.println(a);
        }
    }
}
