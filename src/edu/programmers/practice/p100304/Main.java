package edu.programmers.practice.p100304;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};
//        int[] A = {2,  2,  2,  2};
//        int[] B = {1,  1,  1,  1};
        System.out.println(new Solution().solution(A, B));
    }
}

class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int idxA = A.length - 1;
        int idxB = B.length - 1;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int idx = 0; idx <= idxB; ) {
            if (A[idxA] < B[idxB]) {
                idxA--;
                idxB--;
                answer++;
                continue;
            }
            idxA--;
            idx++;
        }

        return answer;
    }
}
