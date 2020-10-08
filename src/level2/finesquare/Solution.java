package level2.finesquare;

// https://programmers.co.kr/learn/courses/30/lessons/62048?language=java
// TODO : 찢어진 사각형 개수는 w + h - gcd(w, h) ?? 공부
public class Solution {
    public long solution(int w, int h) {
        validateWH(w);
        validateWH(h);
        return ((long)w) * h - (w + h - gcd(w, h));
    }

    int gcd(int num1, int num2) {
        int min = num1 < num2 ? num1 : num2;
        int gcd = 1;
        for (int i = 1; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // W, H : 1억 이하의 자연수
    void validateWH(int wh) {
        if (wh < 1 || 1000000000 < wh) {
            throw new RuntimeException();
        }
    }
}