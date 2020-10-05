package level3.thanksgivingdaytraffic;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        List<Double[]> startTimeEndTime = new ArrayList<>();
        for (String line : lines) {
            String[] dateTimeDuring = dateTimeDuring(line);
            startTimeEndTime.add(startTimeEndTime(dateTimeDuring));
        }


        // 돌면서 isArrange 측정하여 개수 세서 리턴하면됨
        return answer;
    }

    private boolean isArrange(Double[] startTimeEndTime, Double[] compareTime) {
        Double startTime = startTimeEndTime[0];
        Double endTime = startTimeEndTime[1];
        Double compareTime1 = compareTime[0];
        Double compareTime2 = compareTime[2];
        if (compareTime1 > endTime) {
            return false;
        }
        if (compareTime2 < startTime) {
            return false;
        }
        return true;
    }

    private String[] dateTimeDuring(String line) {
        String[] dateTimeDuring = line.split(" ");
        if (dateTimeDuring.length != 3) {
            throw new RuntimeException();
        }
        return dateTimeDuring;
    }

    private Double[] startTimeEndTime(String[] dateTimeDuring) {
        String time = dateTimeDuring[1];
        String during = dateTimeDuring[2].replace("s", "");
        Double[] startTimeEndTime = new Double[]{
                parseTimes(time) - Double.parseDouble(during),
                parseTimes(time)
        };
        return startTimeEndTime;
    }

    private double parseTimes(String time) {
        String[] parseTime = time.split(":");
        if (parseTime.length != 3) {
            throw new RuntimeException();
        }
        return Double.parseDouble(parseTime[0]) * 60 * 60 + Double.parseDouble(parseTime[1]) * 60 + Double.parseDouble(parseTime[2]);
    }
}