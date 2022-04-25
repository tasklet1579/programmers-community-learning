package edu.programmers.practice.p100307;

public class Main {

    public static void main(String[] args) {
//        int n = 2;
        int n = 3;
//        int n = 4;
        System.out.println(new Solution().solution(n));
    }
}

class Solution {

    private int answer = 0, N;

    private int[] bracket = {0, 1}; // {, }
    private int[] use = {1, 0};

    public int solution(int n) {
        N = n;
        bracket(0);
        return answer;
    }

    public void bracket(int u) {
        if (use[0] > N) {
            return;
        }
        if (use[0] < use[1]) {
            return;
        }
        if (use[1] == N) {
            answer++;
            return;
        }

        for (int b : bracket) {
            use[b] += 1;
            bracket(b);
            use[b] -= 1;
        }
    }
}
