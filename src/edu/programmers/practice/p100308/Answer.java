package edu.programmers.practice.p100308;

public class Answer {
    /*
    * 문제 이해
    * 숫자로 구성된 삼각형이 있다
    * 삼각형 꼭대기에서 대각선 방향으로 바닥까지 이동한다
    * 이동하면서 숫자를 더했을 때 거쳐간 숫자의 합이 가장 큰 경우는 그 값이 얼마인가?
    *
    * 문제 설계
    * 다이나믹 프로그래밍
    * 큰 문제를 작은 문제로 나누어 푸는 방법 (중간에 계산된 값을 저장해 두었다가 재사용)
    * 최대값이 될수 있는 값을 더하면서 바닥으로 이동한다
    */
    /*public int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (i == j) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    int left = triangle[i][j] + triangle[i - 1][j - 1];
                    int right = triangle[i][j] + triangle[i - 1][j];
                    triangle[i][j] = Math.max(left, right);
                }

                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }*/

    /*
    * 위에서 올라가면 가장자리에 대한 고려를 하지 않아도 된다
    */
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = triangle[i][j] + triangle[i + 1][j];
                int right = triangle[i][j] + triangle[i + 1][j + 1];
                triangle[i][j] = Math.max(left, right);
            }
        }
        return triangle[0][0];
    }
}
