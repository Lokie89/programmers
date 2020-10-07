package level2.stockprice;

// https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
public class Solution {
    public int[] solution(int[] prices) {
        validatePriceLength(prices);
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            validatePrice(price);
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (price > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    // prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    void validatePrice(int price) {
        if (price < 1 || 10000 < price) {
            throw new RuntimeException();
        }
    }

    // prices의 길이는 2 이상 100,000 이하입니다.
    void validatePriceLength(int[] prices) {
        if (prices.length < 2 || 100000 < prices.length) {
            throw new RuntimeException();
        }
    }

}