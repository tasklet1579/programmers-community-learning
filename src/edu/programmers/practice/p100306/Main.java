package edu.programmers.practice.p100306;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
//        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(new Solution().solution(maps));
    }
}

class Solution {
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[][] visit;

    private static int X = 0;
    private static int Y = 1;
    private static int[] dirX = {0, 1, 0, -1}; // 동 남 서 북
    private static int[] dirY = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        visit = new int[n][m];

        queue.add(new int[]{0, 0});
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] coord = queue.poll();

            if (coord[X] + 1 == n && coord[Y] + 1 == m) {
                return visit[coord[X]][coord[Y]];
            }

            for (int idx = 0; idx < 4; idx++) {
                int nx = coord[X] + dirX[idx];
                int ny = coord[Y] + dirY[idx];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (maps[nx][ny] == 0 || visit[nx][ny] > 0) {
                    continue;
                }

                queue.add(new int[]{nx, ny});
                visit[nx][ny] = visit[coord[X]][coord[Y]] + 1;
            }
        }

        return -1;
    }
}
