package level1.dartgame;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/17682?language=java
public class Solution {
    public int solution(String dartResult) {
        Dart[] darts = strToDart(dartResult);
        int[] answers = new int[3];
        for (int i = 0; i < darts.length; i++) {
            Dart dart = darts[i];
            answers[i] = dart.getPoint();
            String option = dart.getOption();
            if (option.equals("*")) {
                if (i != 0) {
                    answers[i - 1] = answers[i - 1] * 2;
                }
                answers[i] = answers[i] * 2;
            } else if (option.equals("#")) {
                answers[i] = answers[i] * -1;
            }
        }

        return Arrays.stream(answers).sum();
    }

    Dart[] strToDart(String dart) {
        int[] indexes = new int[9];
        char[] dartCharArray = dart.toCharArray();
        int indexCount = 0;
        for (int i = 0; i < dartCharArray.length - 1 && indexCount < 9; i++) {
            char dartChar = dartCharArray[i];
            if (48 <= dartChar && dartChar <= 57) {
                indexes[indexCount] = i;
                indexCount++;
                char dartChar2 = dartCharArray[i + 1];
                if (48 <= dartChar2 && dartChar2 <= 57) {
                    indexes[indexCount] = i + 1;
                    i++;
                } else {
                    indexes[indexCount] = i;
                }
                indexCount++;
                if (indexCount >= dartCharArray.length) {
                    indexes[indexCount] = dartCharArray.length - 1;
                } else {
                    if (indexes[indexCount - 1] + 2 >= dartCharArray.length) {
                        indexes[indexCount] = dartCharArray.length - 1;
                    } else {

                        char option = dartCharArray[indexes[indexCount - 1] + 2];
                        if (48 <= option && option <= 57) {
                            indexes[indexCount] = indexes[indexCount - 1] + 1;
                        } else {
                            indexes[indexCount] = indexes[indexCount - 1] + 2;
                        }
                    }
                }
                indexCount++;
            }
        }

        Dart[] darts = new Dart[3];

        for (int i = 0; i < indexes.length; i += 3) {
            int numStart = indexes[i];
            int numEnd = indexes[i + 1];
            int dartEnd = indexes[i + 2];
            if (dartEnd < numEnd + 2) {
                dartEnd = numEnd + 2;
            } else {
                dartEnd++;
            }
            darts[i / 3] = new Dart(
                    Integer.parseInt(dart.substring(numStart, numEnd + 1)),
                    dart.substring(numEnd + 1, numEnd + 2),
                    dart.substring(numEnd + 2, dartEnd)
            );
        }

        return darts;
    }

    class Dart {
        int num;
        String bonus;
        String option;

        Dart(int num, String bonus, String option) {
            validateNum(num);
            validateBonus(bonus);
            validateOption(option);
            this.num = num;
            this.bonus = bonus;
            this.option = option;
        }

        //점수는 0에서 10 사이의 정수이다.
        void validateNum(int num) {
            if (num < 0 || num > 10) {
                throw new RuntimeException();
            }
        }

        //보너스는 S, D, T 중 하나이다.
        void validateBonus(String bonus) {
            if (!bonus.equals("S") && !bonus.equals("D") && !bonus.equals("T")) {
                throw new RuntimeException();
            }
        }

        //옵선은 *이나 # 중 하나이며, 없을 수도 있다.
        void validateOption(String option) {
            if (!option.equals("") && !option.equals("*") && !option.equals("#")) {
                throw new RuntimeException();
            }
        }

        int getPoint() {
            if (bonus.equals("D")) {
                return (int) Math.pow(num, 2);
            } else if (bonus.equals("T")) {
                return (int) Math.pow(num, 3);
            }
            return num;
        }

        String getOption() {
            return option;
        }
    }
}