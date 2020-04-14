package level1.crane;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> basket;

    public Solution() {
        basket = new ArrayList<>();
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        for (int index : moves) {
            answer += loopBoard(board, index - 1);
        }
        return answer;
    }

    private int loopBoard(int[][] board, int index) {
        int answer = 0;
        for (int[] row : board) {
            int returnNum = pickNumber(row, index);
            answer += returnNum;
            if (returnNum != 0) {
                break;
            }
        }
        return answer;
    }


    private int pickNumber(int[] numbers, int index) {
        if (!isEmpty(numbers[index])) {
            return addBasket(numbers[index]);
        }
        return 0;
    }

    private int addBasket(int number) {
        if (!isSameWithLastBasketNumber(number)) {
            basket.add(number);
            return 0;
        }
        basket.remove(basket.size() - 1);
        return 2;
    }

    private boolean isSameWithLastBasketNumber(int number) {
        if (basket.size() > 0) {
            return basket.get(basket.size() - 1) == number;
        }
        return false;
    }

    private boolean isEmpty(int number) {
        return number == 0;
    }
}

class test {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(new Solution().solution(board, moves));
    }
}
