package level1.crane;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> basket;
    private int answer = 0;

    public Solution() {
        basket = new ArrayList<>();
    }

    public int solution(int[][] board, int[] moves) {
        validateBoardLength(board);
        validateMovesLength(moves);
        for (int index : moves) {
            loopBoard(board, index - 1);
        }
        return answer;
    }

    private void validateBoardLength(int[][] board) {
        if (board[0].length < 5) {
            throw new RuntimeException();
        }
        if (board[0].length > 30) {
            throw new RuntimeException();
        }
    }

    private void validateMovesLength(int[] moves) {
        if (moves.length < 1) {
            throw new RuntimeException();
        }
        if (moves.length > 1000) {
            throw new RuntimeException();
        }
    }

    private void loopBoard(int[][] board, int index) {
        for (int i = 0; i < board.length; i++) {
            if (pickNumber(board[i], index)) {
                replaceZero(board, i, index);
                break;
            }
        }
    }

    private void replaceZero(int[][] board, int row, int col) {
        board[row][col] = 0;
    }


    private boolean pickNumber(int[] numbers, int index) {
        validateIndex(index);
        final int number = numbers[index];
        validateNumber(number);
        if (!isEmpty(number)) {
            addBasket(number);
            return true;
        }
        return false;
    }

    private void validateIndex(int index) {
        if (index < 0) {
            throw new RuntimeException();
        }
        if (index > 29) {
            throw new RuntimeException();
        }

    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        if (number > 100) {
            throw new RuntimeException();

        }
    }

    private void addBasket(int number) {
        if (!isSameWithLastBasketNumber(number)) {
            basket.add(number);
            return;
        }
        basket.remove(basket.size() - 1);
        answer += 2;
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
