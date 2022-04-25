package edu.programmers.practice.p100308;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(new Solution().solution(triangle));
    }
}

class Solution {

    private int answer = 0;
    private int height;
    private int[][] tree;

    // 실패 (시간 초과)
    // public int solution(int[][] triangle) {
    //     height = triangle.length;
    //     tree = new int[height][];
    //     for (int idx = 0; idx < height; idx++) {
    //         tree[idx] = new int[triangle[idx].length];
    //         System.arraycopy(triangle[idx], 0, tree[idx], 0, triangle[idx].length);
    //     }
    //     find(0, 0, 0);
    //     return answer;
    // }
    //
    // public void find(int depth, int loc, int sum) {
    //     if (depth == height) {
    //         if (answer < sum) {
    //             answer = sum;
    //         }
    //         return;
    //     }
    //
    //     sum += tree[depth][loc];
    //     find(depth + 1, loc, sum);
    //     find(depth + 1, loc + 1, sum);
    // }

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
