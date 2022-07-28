package edu.programmers.practice.p100301;

public class Main {

    public static void main(String[] args) {
//        int n = 11;
//        int[] stations = {4,  11};
//        int w = 1;
//        int n = 16;
//        int[] stations = {9};
//        int w = 2;
        int n = 7;
        int[] stations = {2};
        int w = 1;
        System.out.println(new Solution().solution(n, stations, w));
    }
}

class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int begin = 1, end; // 전파가 도달하지 않는 구간
        int next;

        for (int idx = 0; begin <= n; ) {
            if (idx < stations.length) {
                end = Math.max(1, stations[idx] - w);
                next = stations[idx++] + w + 1;
            } else {
                end = n + 1; // 마지막 구간에서는 +1 해준다
                next = n + 1; // 반복문 종료 처리
            }

            if (end - begin > 0) {
                int remainder = (end - begin) % (2 * w + 1);
                int quotient = (end - begin) / (2 * w + 1);
                answer += (remainder == 0) ? quotient : quotient + 1;
            }

            begin = next;
        }

        return answer;
    }
}
