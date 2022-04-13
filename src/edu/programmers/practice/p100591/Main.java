package edu.programmers.practice.p100591;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] budgets = {120,  110,  140,  150};
//        int[] budgets = {1,  2,  3,  5,  6};
//        int M = 485;
        int[] budgets = {3,  3,  3};
        int M = 6;
        System.out.println(new Solution().solution(budgets,  M));
    }
}

// 정확성 테스트 9 실패
// 효율성 테스트 2 실패
class Solution {

    public int solution(int[] budgets,  int M) {
        int answer = 0;
        int idx = 0;
        int sum = 0;
        int max = 0;

        while (idx < budgets.length) {
            sum += budgets[idx];
            answer = Math.max(answer,  budgets[idx++]);
        }

        if (sum <= M) {
            return answer;
        }

        Arrays.sort(budgets);

        idx = 0;
        sum = 0;
        answer = 0;

        while (idx < budgets.length) {
            if (M - sum < budgets[idx]) {
                break;
            }

            sum += budgets[idx];

            int numerator = M - sum;
            int denominator = budgets.length - idx - 1;
            int available = numerator / denominator;

            if (max < available) {
                max = available;
                answer = available;
            }

            idx++;
        }

        return answer;
    }
}
