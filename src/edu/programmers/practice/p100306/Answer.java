package edu.programmers.practice.p100306;

import java.util.LinkedList;
import java.util.Queue;

public class Answer {
    /*
    * 문제 이해
    * 미로의 시작점에서 목적지까지의 최단 거리를 구하라
    * 전형적인 넓이 우선 탐색 문제
    * 이동할 수 있는 경우의 수를 모두 확인해서 문제를 해결한다
    * 동, 서, 남, 북 방향으로 한 칸씩 이동하며
    * 이동한 후의 다음 위치는 각 방향에 의해서 다시 결정된다
    * 지나온 곳으로는 다시 되돌아가지 않는다
    * 데이터 이동을 모두 추적하기에는 너무 복잡하다
    * 모든 경우에 동일하게 적용할 수 있는 규칙과 종료 조건을 생각하자
    *
    * 문제 설계
    * 네 방향으로 한 칸씩 이동한다
    * 이동한 후에는 현재값보다 1 큰 값을 채운다
    * 벽, 미로 밖, 왔던 길로는 못간다
    * 이동 후 위치가 목적지면 종료한다
    */
    public int solution(int[][] maps) {
        int mapHeight = maps.length;
        int mapWidth = maps[0].length;

        int[][] count = new int[mapHeight][mapWidth];
        boolean[][] visited = new boolean[mapHeight][mapWidth];

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0));
        count[0][0] = 1;
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            int currentCount = count[current.y][current.x];

            final int[][] moving = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
            for (int i = 0; i < moving.length; i++) {
                Position moved = new Position(current.x + moving[i][0], current.y + moving[i][1]);

                if (!moved.isValid(mapWidth, mapHeight)) continue;
                if (visited[moved.y][moved.x]) continue;
                if (maps[moved.y][moved.x] == 0) continue;

                queue.offer(moved);
                count[moved.y][moved.x] = currentCount + 1;
                visited[moved.y][moved.x] = true;
            }
        }

        int answer = count[mapHeight - 1][mapWidth - 1];
        if (answer == 0) return -1;
        return answer;
   }

   static class Position {
       int x, y;

       public Position(int x, int y) {
           this.x = x;
           this.y = y;
       }

       boolean isValid(int width, int height) {
           if (x < 0 || x >= width) return false;
           if (y < 0 || y >= height) return false;
           return true;
       }
   }
}
