package level1.dartgame;

// https://programmers.co.kr/learn/courses/30/lessons/17682?language=java
//TODO
public class Solution {
    public int solution(String dartResult) {
        return 0;
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
            if (option != null && !option.equals("*") && !option.equals("#")) {
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