package edu.programmers.practice.p10145;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        int max_virus = 2;
        int[][] queries = {{3, 2}, {3, 2}, {2, 2}, {3, 2}, {1, 4}, {3, 2}, {2, 3}, {3, 1}};
        System.out.println(Arrays.deepToString(new Solution().solution(rows, columns, max_virus, queries)));
    }
}

class Solution {
    private final Queue<int[]> queue = new LinkedList<>();
    private final int[] dirX = {0, 1, 0, -1};
    private final int[] dirY = {-1, 0, 1, 0};
    private final int X = 0;
    private final int Y = 1;

    private int[][] virus;
    private int[][] visit;

    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        virus = new int[rows][columns];

        for (int[] query : queries) {
            int coordX = query[X] - 1;
            int coordY = query[Y] - 1;

            if (virus[coordX][coordY] < max_virus) {
                virus[coordX][coordY] += 1;
                continue;
            }

            queue.add(new int[]{coordX, coordY});
            visit = new int[rows][columns];

            while (!queue.isEmpty()) {
                int[] q = queue.poll();

                if (q[X] < 0 || q[X] >= rows || q[Y] < 0 || q[Y] >= columns) {
                    continue;
                }
                if (visit[q[X]][q[Y]] > 0) {
                    continue;
                }
                visit[q[X]][q[Y]] = 1;

                if (virus[q[X]][q[Y]] < max_virus) {
                    virus[q[X]][q[Y]] += 1;
                    continue;
                }

                for (int idx = 0; idx < dirX.length; idx++) {
                    queue.add(new int[]{q[X] + dirX[idx], q[Y] + dirY[idx]});
                    visit[q[X]][q[Y]] = 1;
                }
            }
        }

        return virus;
    }
}
