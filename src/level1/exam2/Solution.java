package level1.exam2;

import java.util.Arrays;

public class Solution {

    // 북동남서 0 1 2 3
    int direction = 0;
    int y;
    int x;

    public int solution(int[][] office, int r, int c, String[] move) {
        validateOfficeLength(office);
        validateMoveLength(move);
        validateRobotStartPoint(office, r, c);
        y = r;
        x = c;

        int answer = 0;
        final int moveLength = move.length;
        for (int i = 0; i < moveLength; i++) {
            String m = move[i];
            validateMove(m);
            if (!changeDirection(m)) {
                answer += moveOffice(office);
            }
        }
        return answer;
    }

    private int moveOffice(int[][] office) {
        int dust = 0;
        switch (direction) {
            case 0:
                y--;
                if (y < 0) {
                    y++;
                    break;
                }
                dust = office[y][x];
                validateOfficeNumber(dust);
                if (dust == -1) {
                    y++;
                    dust = 0;
                    break;
                }
                office[y][x] = 0;
                break;
            case 1:
                x++;
                if (x > office.length) {
                    x--;
                    break;
                }
                dust = office[y][x];
                validateOfficeNumber(dust);
                if (dust == -1) {
                    x--;
                    dust = 0;
                    break;
                }
                office[y][x] = 0;
                break;
            case 2:
                y++;
                if (y > office.length) {
                    y--;
                    break;
                }
                dust = office[y][x];
                validateOfficeNumber(dust);
                if (dust == -1) {
                    y--;
                    dust = 0;
                    break;
                }
                office[y][x] = 0;
                break;
            case 3:
                x--;
                if (x < 0) {
                    x++;
                    break;
                }
                dust = office[y][x];
                validateOfficeNumber(dust);
                if (dust == -1) {
                    x++;
                    dust = 0;
                    break;
                }
                office[y][x] = 0;
                break;
        }
        return dust;
    }

    private void validateMove(String move) {
        if (!Move.isMove(move)) {
            throw new RuntimeException();
        }
    }


    private boolean changeDirection(String m) {
        boolean isChange = false;
        if (Move.left.name().equals(m)) {
            direction -= 1;
            isChange = true;
        }
        if (Move.right.name().equals(m)) {
            direction += 1;
            isChange = true;
        }
        inDirectionNumber();
        return isChange;
    }

    private void inDirectionNumber() {
        final int minDirectionNumber = 0;
        final int maxDirectionNumber = 3;
        if (isOverNumber(direction, maxDirectionNumber)) {
            direction -= 4;
        }
        if (isOverNumber(minDirectionNumber, direction)) {
            direction += 4;
        }
    }

    private void validateOfficeLength(int[][] office) {
        final int officeLength = office.length;
        final int minLength = 2;
        final int maxLength = 20;
        if (isOverNumber(officeLength, maxLength)) {
            throw new RuntimeException();
        }
        if (isOverNumber(minLength, officeLength)) {
            throw new RuntimeException();
        }
    }

    private void validateMoveLength(String[] move) {
        final int moveLength = move.length;
        final int minLength = 1;
        final int maxLength = 200;
        if (isOverNumber(moveLength, maxLength)) {
            throw new RuntimeException();
        }
        if (isOverNumber(minLength, moveLength)) {
            throw new RuntimeException();
        }
    }

    private void validateRobotStartPoint(int[][] office, int r, int c) {
        final int canStartOverNumber = -1;
        if (!isOverNumber(office[r][c], canStartOverNumber)) {
            throw new RuntimeException();
        }
    }

    private boolean isSameNumber(int number1, int number2) {
        return number1 == number2;
    }

    private void validateOfficeNumber(int number) {
        final int minNumber = -1;
        final int maxNumber = 100;
        if (isOverNumber(number, maxNumber)) {
            throw new RuntimeException();
        }
        if (isOverNumber(minNumber, number)) {
            throw new RuntimeException();
        }
    }

    private boolean isOverNumber(int number, int compareNumber) {
        return number > compareNumber;
    }

    enum Move {
        go,
        left,
        right,
        ;

        public static boolean isMove(String m) {
            return Arrays.stream(Move.values())
                    .filter(move -> move.name().equals(m))
                    .count() == 1;
        }
    }

}
