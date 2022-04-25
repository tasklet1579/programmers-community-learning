package edu.programmers.practice.p10144;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] s1 = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
        String[] s2 = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
        String k = "B";
//        String[] s1 = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
//        String[] s2 = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
//        String k = "G";
        System.out.println(Arrays.toString(new Solution().solution(s1, s2, k)));
        // "D", "H", "E", "C", "F", "B"
        // "A", "D", "H", "E", "C", "F", "B", "G"
    }
}

class Solution {

    public String[] solution(String[] s1, String[] s2, String k) {
        String[] answer = {};

        return answer;
    }
}
