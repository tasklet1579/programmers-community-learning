package edu.programmers.practice.p100591;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] budgets = {120, 110, 140, 150};
//        int M = 485;
        int[] budgets = {1, 1, 1, 1};
        int M = 4;
        System.out.println(new Solution().solution(budgets, M));
    }
}

class Solution {

    public int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        int min = 0;
        int max = budgets[budgets.length - 1];
        int mid = (min + max) / 2;

        while (min <= max) {
            int sum = 0;
            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }

            if (sum <= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            mid = (min + max) / 2;
        }

        return mid;
    }
}
