package edu.programmers.practice.p100230;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] people = {2,  3};
//        int[] tshirts = {1,  2,  3};
        int[] people = {1, 2, 3};
        int[] tshirts = {1, 1};
        System.out.println(new Solution().solution(people, tshirts));
    }
}

class Solution {

    public int solution(int[] people, int[] tshirts) {
        int answer = 0;

        Arrays.sort(people);
        Arrays.sort(tshirts);

        for (int idxP = 0, idxT = 0; idxP < people.length && idxT < tshirts.length; idxT++) {
            if (people[idxP] <= tshirts[idxT]) {
                idxP++;
                answer++;
            }
        }

        return answer;
    }
}
