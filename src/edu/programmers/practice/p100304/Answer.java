package edu.programmers.practice.p100304;

import java.util.Arrays;

public class Answer {

    /*
    * 문제 이해
    * A팀 B팀이 있고 숫자를 공개했을 때 숫자가 큰 팀이 승점을 얻는다
    * 같은 숫자를 공개하는 경우 어느 누구도 승점을 얻지 않는다
    * A팀은 숫자와 순서가 정해져 있고 B팀이 최대 승점을 얻도록 순서를 정했을 때
    * B팀의 최대 승점은 몇점인가?
    * A A팀이 부여받은 숫자와 순서
    * B B팀이 부여받은 숫자와 순서
    *
    * 문제 설계
    * B팀이 출전할 수 있는 모든 경우의 수를 비교해보고 승점을 계산해서 최대값을 구하면 된다
    * 모든 경우의 수를 확인하고 원하는 결과를 얻는다면 탐색법으로 풀면 된다
    * 하지만 B팀이 최대 승점으로 승리한다는 조건이 있고 이 조건에 맞는 상황을 재현하면 된다
    * 특정 상황을 재현해서 문제를 해결한다 이것을 시뮬레이션 한다 라고 한다
    * B팀의 숫자가 근소한 차이로 A보다 큰 경우 최대 승점을 얻을 수 있다
    * B의 작은 값부터 시작해서 A보다 큰 숫자를 제거하면서 승점을 계산한다
    */
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        /*for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] < B[j]) {
                    answer++;
                    B[j] = 0;
                    break;
                }
            }
        }*/

        for (int idxA = A.length - 1, idxB = B.length - 1; idxA >= 0; idxA--) {
            if (A[idxA] < B[idxB]) {
                idxB--;
                answer++;
            }
        }

        return answer;
    }
}
