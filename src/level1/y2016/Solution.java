package level1.y2016;

// https://programmers.co.kr/learn/courses/30/lessons/12901?language=java

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    public String solution(int a, int b) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(116, a - 1, b));

        int c = calendar.get(Calendar.DAY_OF_WEEK);
        String answer = Day.getInstance(c).name();
        return answer;
    }

    enum Day {
        SUN(1),
        MON(2),
        TUE(3),
        WED(4),
        THU(5),
        FRI(6),
        SAT(7),
        ;
        private int dayOfWeek;

        Day(int dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        public static Day getInstance(int dayOfWeek) {
            return Arrays.asList(Day.values())
                    .stream()
                    .filter(day -> day.dayOfWeek == dayOfWeek)
                    .findFirst()
                    .get()
                    ;
        }
    }
}
// 2016년은 윤년입니다.
// 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)