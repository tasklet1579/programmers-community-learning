package edu.programmers.practice.p100301;

import java.util.LinkedList;
import java.util.Queue;

public class Answer {
    /*
     * 문제 이해
     * 아파트가 여러 동으로 구성되어 있고 일부 아파트에 기지국이 설치되어 있다
     * 기지국은 전파 도달 범위가 제한되어 있어서 일부 전파가 도달하지 않은 아파트들이 있다
     * 현재 상태에서 최소 몇 개의 기지국을 더 설치해야 모든 아파트들이 전파 범위에 들어가는가?
     * n 아파트 동 수
     * stations 기지국이 설치되어 아파트
     * w 전파 범위
     *
     * 문제 설계
     * 첫 번째 아파트부터 마지막 아파트까지 탐색한다
     * 현재 바라보고 있는 아파트가 전파 범위에 속하지 않는다면 기지국을 설치한다
     * 기지국을 세울 때는 전파 범위의 효과가 최대가 되도록 전파 범위만큼 이동해서 기지국을 설치한다
     * 그 다음 기지국 위치는 전파 범위가 끝나는 지점 이후를 살펴본다
     * 이 과정을 반복한다
     * 이미 설치된 기지국이 있고 전파 범위와 겹친다면 해당 기지국의 전파가 끝나는 지점 이후를 살펴본다
     * 이 과정을 반복한다
     * 전파가 도달하지 않는 곳에 기지국을 설치하면서 현재의 상태만을 고려하면서 욕심쟁이처럼 탐욕적으로
     * 지금 당장의 문제 해결 방식을 적용한다
     */
    /*public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;
        int position = 1;
        Queue<Integer> sq = new LinkedList<>();

        for (int s : stations) {
            sq.offer(s);
        }

        while (position <= n) {
            if (!sq.isEmpty() && sq.peek() - w <= position) {
                position = sq.poll() + w + 1;
            } else {
                answer += 1;
                position += 2 * w + 1;
            }
        }
        return answer;
    }*/

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;
        int position = 1;

        /*
         * Tip. 효율성 높이기
         * 1. Loop 개선
         * 2. 적절한 데이터 구조 사용
         * 3. 불필요한 오브젝트 제거
         *    자바에서 오브젝트를 사용하는 것이 그렇게 큰 오버헤드가 발생하는 것은 아니지만
         *    더 빠르고 효율적인 프로그램을 만들어야 한다면 프리미티브 타입 사용을 고려해보자
         */
        while (position <= n) {
            if (si < stations.length && stations[si] - w <= position) {
                position = stations[si++] + w + 1;
            } else {
                answer += 1;
                position += 2 * w + 1;
            }
        }
        return answer;
    }
}
