package level1.pushkeypad;

// https://programmers.co.kr/learn/courses/30/lessons/67256?language=java
// TODO
public class Solution {

    public String solution(int[] numbers, String hand) {
        validateNumberLength(numbers);
        validateHand(hand);
        int currentLeft = -1;
        int currentRight = -1;
        String answer = "";

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer += "L";
                currentLeft = number;
                continue;
            }
            if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                currentRight = number;
                continue;
            }

            int leftDistance = midDistance(number, currentLeft);
            int rightDistance = midDistance(number, currentRight);
            if (leftDistance < rightDistance) {
                answer += "L";
                currentLeft = number;
            } else if (leftDistance > rightDistance) {
                answer += "R";
                currentRight = number;
            } else {
                answer += hand.substring(0, 1).toUpperCase();
                if (hand.equals("right")) {
                    currentRight = number;
                } else {
                    currentLeft = number;
                }
            }
        }

        return answer;
    }


    private int midDistance(int destination, int current) {
        int distance = 0;
        if (current == 0) {

        } else if (current == -1) {
            current += 1;
            distance++;
        } else if (current % 3 == 0) {
            current -= 1;
            distance++;
        } else if (current % 3 == 1) {
            current += 1;
            distance++;
        }

        switch (destination) {
            case 2:
                if (current == 5) {
                    distance += 1;
                } else if (current == 8) {
                    distance += 2;
                } else if (current == 0) {
                    distance += 3;
                }
                break;
            case 5:
                if (current == 2) {
                    distance += 1;
                } else if (current == 8) {
                    distance += 1;
                } else if (current == 0) {
                    distance += 2;
                }
                break;
            case 8:
                if (current == 2) {
                    distance += 2;
                } else if (current == 5) {
                    distance += 1;
                } else if (current == 0) {
                    distance += 1;
                }
                break;
            case 0:
                if (current == 2) {
                    distance += 3;
                } else if (current == 5) {
                    distance += 2;
                } else if (current == 8) {
                    distance += 1;
                }
                break;
        }
        return distance;
    }

    // numbers 배열의 크기는 1 이상 1,000 이하입니다.
    private void validateNumberLength(int[] numbers) {
        if (numbers.length < 1 || numbers.length > 1000) {
            throw new RuntimeException();
        }
    }

    // numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
    private void validateNumber(int number) {
        if (number < 0 || number > 9) {
            throw new RuntimeException();
        }
    }

    // hand는 "left" 또는 "right" 입니다.
    private void validateHand(String hand) {
        if (!hand.equals("left") && !hand.equals("right")) {
            throw new RuntimeException();
        }
    }

    // "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
    //왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
}