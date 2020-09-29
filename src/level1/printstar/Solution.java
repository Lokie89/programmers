package level1.printstar;

import java.util.Scanner;


// https://programmers.co.kr/learn/courses/30/lessons/12969?language=java
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        validateNumber(a);
        validateNumber(b);

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // n과 m은 각각 1000 이하인 자연수입니다.
    private static void validateNumber(int n) {
        if (n < 1 || n > 1000) {
            throw new RuntimeException();
        }
    }
}