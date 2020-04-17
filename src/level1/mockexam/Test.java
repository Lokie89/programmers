package level1.mockexam;

public class Test {
    public static void main(String[] args) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] solution1 = new Solution().solution(answer1);
        for (int i : solution1) {
            System.out.print(i + " "); // 1
        }
        System.out.println();
        int[] answer2 = {1, 3, 2, 4, 2};
        int[] solution2 = new Solution().solution(answer2);
        for (int i : solution2) {
            System.out.print(i + " "); // 1 2 3
        }
    }
}
