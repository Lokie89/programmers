package level2.nation124;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/12899?language=java
public class Solution {
    public String solution(int n) {
        validateN(n);
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            if (n % 3 == 0) {
                n -= 3;
            }
            stack.push(n % 3);
            n /= 3;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            switch (pop - 1) {
                case 0:
                    sb.append("1");
                    break;
                case 1:
                    sb.append("2");
                    break;
                case -1:
                    sb.append("4");
                    break;
            }
        }
        return sb.toString();
    }

    // n은 500,000,000이하의 자연수 입니다.
    void validateN(int n) {
        if (n < 1 || 500000000 < n) {
            throw new RuntimeException();
        }
    }

    //정답
//    public String solution(int n) {
//        String[] num = {"4","1","2"};
//        String answer = "";
//
//        while(n > 0){
//            answer = num[n % 3] + answer;
//            n = (n - 1) / 3;
//        }
//        return answer;
//    }
}