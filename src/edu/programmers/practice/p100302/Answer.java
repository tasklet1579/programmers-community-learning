package edu.programmers.practice.p100302;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Answer {

    /*
    * 문제 이해
    * 여러 개의 정수가 주어질 때 정수를 이어 붙여 만들 수 있는 가장 큰 수는 무엇인가?
    * 정수는 0 또는 양의 정수가 주어진다
    * 이 문제의 함정
    * 배열의 숫자가 3자리 총 10개가 주어진다면 30자리의 숫자가 만들어진다
    * 그렇게 되면 int의 범위를 초과하게 된다
    * double을 사용한다 해도 배열이 길어지면 double 역시 범위를 초과하게 된다
    * 반환하는 타입이 문자열이기 때문에 문자열로 다루는 것을 생각하는 것이 더 자연스럽다
    * numbers 0 또는 양의 정수가 담긴 배열
    *
    * 문제 설계
    * 큰 숫자순으로 만드는 것은 정답이 될 수 없다 10 6 2
    * 숫자로서 큰 수가 아니라 글자순으로 구성되는 특징이 있다
    * 숫자 → 문자 → 내림차순 정렬 → 조합
    */
    /*public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] str = new String[numbers.length];

        for (int idx = 0; idx < numbers.length; idx++) {
            str[idx] = String.valueOf(numbers[idx]);
        }

        // 시간 초과
        // 연산 자체가 너무 느리다
        for (int idx = 0; idx < numbers.length; idx++) {
            for (int jdx = idx + 1; jdx < numbers.length; jdx++) {
                String num1 = str[idx];
                String num2 = str[jdx];

                if ((num1 + num2).compareTo(num2 + num1) < 0) {
                    str[idx] = num2;
                    str[jdx] = num1;
                }
            }
        }

        for (String num : str) {
            answer.append(num);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }*/

    /*public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] str = new String[numbers.length];

        for (int idx = 0; idx < numbers.length; idx++) {
            str[idx] = String.valueOf(numbers[idx]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String num1, String num2) {
                return (num2 + num1).compareTo(num1 + num2);
            }
        });

        Arrays.sort(str, (num1, num2) -> (num2 + num1).compareTo(num1 + num2));

        for (String num : str) {
            answer.append(num);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }*/

    public String solution(int[] numbers) {
        /*
        * Tip. 라이브러리 활용
        * Java 언어를 사용한다 == Java가 제공하는 기본 라이브러리를 사용한다.
        * 기본 라이브러리인 java.lang.* 과 java.util.* 의 사용법을 숙지한다.
        */
        String answer = IntStream.of(numbers)
                                 .mapToObj(String::valueOf)
                                 .sorted((num1,  num2) -> (num2 + num1).compareTo((num1 + num2)))
                                 .collect(Collectors.joining());

        if (answer.startsWith("0")) {
            return "0";
        } else {
            return answer;
        }
    }
}
