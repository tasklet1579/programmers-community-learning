package edu.programmers.practice.p100308;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(new Solution().solution(triangle));
    }
}

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;

        for (int idx = 1; idx < triangle.length; idx++) {
            for (int jdx = 0; jdx < triangle[idx].length; jdx++) {
                if (jdx == 0) {
                    triangle[idx][jdx] += triangle[idx - 1][jdx];
                } else if (jdx == triangle[idx].length - 1) {
                    triangle[idx][jdx] += triangle[idx - 1][jdx - 1];
                } else {
                    triangle[idx][jdx] += Math.max(triangle[idx - 1][jdx - 1], triangle[idx - 1][jdx]);
                }
            }
        }

        return IntStream.of(triangle[height - 1])
                        .max()
                        .orElse(0);
    }
}
