package level1.evenoddnumber;

// https://programmers.co.kr/learn/courses/30/lessons/12937?language=java
public class Solution {
    public String solution(int num) {
        String answer = "";
        if(num%2==0){
            answer = "Even";
        }else{
            answer = "Odd";
        }
        return answer;
    }

    // num은 int 범위의 정수입니다.
    // 0은 짝수입니다.
}