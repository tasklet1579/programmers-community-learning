package edu.programmers.practice.p100591;

import java.util.stream.IntStream;

public class Answer {

    /*
     * 문제 이해
     * 국가의 총 예산 범위 내에서 최대한 많은 예산을 지방에 분배하려고 한다
     * 그 때 최대한 많은 예산을 분배하기 위한 상한액은 얼마인지 계산하라
     * 상한액 이하의 요청에 대해서는 요청한 금액을 그대로 배정한다
     * M 총 예산
     * budget 각 지방에서 요청하는 예산이 담긴 배열
     *
     * 문제 설계
     * 주어진 데이터에서 특정 데이터를 찾는 것을 탐색이라고 한다
     * 가장 단순한 방법은 모든 경우의 수를 순회하면서 값을 찾는다
     * 하지만 시간이 너무 오래 걸린다
     * 이 문제에서 찾는 값은 금액이고 최소값과 최대값이 주어진다
     * 최소값 최대값이기 때문에 금액을 데이터로 보면 정렬되어 있는 것과 같다
     * 데이터가 정렬된 상태라면 이분 탐색을 적용할 수 있다
     * 이분 탐색은 범위를 줄여가면서 값을 찾는 방식
     * 중간값을 상한액으로 했을 때 총합이 예산을 초과하는지 확인한다
     * 예산을 초과하지 않는다면 상한액은 중간값과 최대값 사이에 존재하게 된다
     * 새로운 범위 내에서 중간값이 예산을 초과하는지 탐색한다
     * 중간값이 예산을 초과하는 경우 상한액은 최소값과 중간값 사이에 존재하게 된다
     * 이 과정은 최소값과 최대값이 어떤값으로 수렴할 때까지 반복한다
     */
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int min = 0, max = IntStream.of(budgets)
                                    .max()
                                    .orElse(0);

        /*for (int b : budgets) {
            if (b > max) {
                max = b;
            }
        }*/

        /*
         * Tip. 좋은 프로그램을 만드는 방법
         * 1. 당면한 문제를 해결한다
         * 2. 좋은 코드가 되도록 계속 리팩토링 한다
         */
        while (min <= max) {
            final int mid = (min + max) / 2; // 스트림을 사용할 때 가변 변수를 사용하면 안 된다
            int sum = IntStream.of(budgets)
                               .map(b -> Math.min(b, mid))
                               .sum();

            /*int sum = 0;
            for (int b : budgets) {
                if (b > mid) {
                    sum += mid;
                } else {
                    sum += b;
                }
            }*/

            if (sum <= M) {
                min = mid + 1; // 중간값은 이미 한 번 사용했기 때문에 +1 한다
                answer = mid;
            } else {
                max = mid - 1; // 중간값은 이미 한 번 사용했기 때문에 -1 한다
            }
        }

        return answer;
    }
}
