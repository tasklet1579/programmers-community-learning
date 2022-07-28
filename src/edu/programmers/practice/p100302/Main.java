package edu.programmers.practice.p100302;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2}; // 6210
//        int[] numbers = {6,  10,  2,  1}; // 62110
//        int[] numbers = {0,  0}; // 0
//        int[] numbers = {9,  5,  342,  34,  3}; // 95343423
//        int[] numbers = {3,  30,  34,  5,  9}; // 9534330
        System.out.println(new Solution().solution(numbers));
    }
}

class Solution {

    // 순열의 개수는 n! 이기 때문에 모든 숫자를 생성하고 정렬하면 시간 초과가 발생한다
    public String solution(int[] numbers) {
        String answer = "";
        List<Integer> store = new LinkedList<>();

        for (int number : numbers) {
            store.add(number);
        }

        store.sort(new Comparison().reversed());

        if (store.get(0) == 0) {
            return "0";
        }

        for (int number : store) {
            answer = answer.concat(String.valueOf(number));
        }

        return answer;
    }
}

class Comparison implements Comparator<Integer> {

    @Override
    public int compare(Integer int1, Integer int2) {
        String str1 = parseString(int1);
        String str2 = parseString(int2);

        return Integer.compare(parseInt(str1 + str2), parseInt(str2 + str1));
    }

    public String parseString(int int1) {
        return String.valueOf(int1);
    }

    public int parseInt(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public Comparator<Integer> reversed() {
        return Comparator.super.reversed();
    }
}
