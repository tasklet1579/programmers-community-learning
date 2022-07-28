package edu.programmers.practice.p100305;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Answer {

    /*
    * 문제 이해
    * 스파이가 선택할 수 있는 옷의 종류가 존재하고
    * 종류별로 조합할 수 있는 옷의 모든 경우의 수를 구하라
    * 위장 용품은 선택할 수도 있고 선택하지 않을 수도 있다
    * 위장 용품의 각 개수를 곱하면 모든 경우의 수를 구할 수 있다
    * 하지만 위장 용품을 선택하지 않을 수도 있기 때문에
    * 경우의 수에 +1 해서 곱해주고
    * 모두 선택하지 않은 경우가 있기 때문에 최종 결과에서 -1 한다
    *
    * 문제 설계
    * 문제의 핵심은 경우의 수를 구하는 것이 아니라
    * 옷의 종류별로 개수를 카운트하는 것이다
    * 배열은 값을 찾기 위해 처음부터 모두 탐색해야 하고
    * 옷의 종류는 미리 주어지지 않기 때문에 배열을 사용할 수 없다
    * 이런 경우에는 인덱스가 아닌 키값으로 정보를 저장할 수 있는 해시를 사용한다
    * 해시는 주어진 키에 대한 해시값을 계산하고 이 값을 데이터를 저장하는데 사용한다
    * 해시값을 얻을 수 있다면 탐색없이 바로 데이터에 접근할 수 있다
    * 해시값은 해시 함수를 통해서 얻은 값을 의미하는데
    * 해시 함수는 최대한 겹치지 않도록 유니크한 값을 생성한다
    * 해시의 자료구조를 이해하기 위해서는 배열, 리스트, 탐색, 해시같은
    * 여러 요소를 복합적으로 사용해야 한다
    */
    /*public int solution(String[][] clothes) {
        Map<String, Integer> counts = new HashMap<>();

        for (String[] c : clothes) {
            String type = c[1];
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (Integer c : counts.values()) {
            answer *= c + 1;
        }

        answer -= 1;

        return answer;
    }*/

    /*
    * Tips. 코딩 스킬을 향상시키는 방법
    * 1. 문제를 풀이한다.
    * 2. 다른 방식으로 풀어본다.
    * 3. 다른 표현으로 바꿔본다.
    */
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                     .map(c -> c[1])
                     .distinct()
                     .map(type -> (int) Arrays.stream(clothes)
                                              .filter(c -> c[1].equals(type))
                                              .count())
                     .map(c -> c + 1)
                     .reduce(1, (c, n) -> c * n) - 1;
    }
}
