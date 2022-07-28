package edu.programmers.practice.p100229;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        String[][] booked = {{"09:10",  "lee"}};
//        String[][] unbooked = {{"09:00",  "kim"},  {"09:05",  "bae"}};
//        String[][] booked = {{"09:55",  "hae"},  {"10:05",  "jee"}};
//        String[][] unbooked = {{"10:04",  "hee"},  {"14:07",  "eom"}};
        String[][] booked = {{"10:05", "hae"}, {"10:26", "jee"}};
        String[][] unbooked = {{"10:04", "hee"}, {"10:25", "eom"}};
        System.out.println(Arrays.toString(new Solution().solution(booked, unbooked)));
    }
}

class Solution {

    private static final int ARRIVAL = 0;
    private static final int NAME = 1;

    public String[] solution(String[][] booked, String[][] unbooked) {
        String[] answer = new String[booked.length + unbooked.length];
        int idxA = 0, idxB = 0, idxU = 0;

        int timeB = time(booked, idxB);
        int timeU = time(unbooked, idxU);
        int timer = Math.min(timeB, timeU);

        while (idxB < booked.length && idxU < unbooked.length) {
            timeB = time(booked, idxB);
            timeU = time(unbooked, idxU);

            if (timeB <= timer) {
                answer[idxA++] = booked[idxB++][NAME];
                timer += 10;
            } else if (timeU <= timer) {
                answer[idxA++] = unbooked[idxU++][NAME];
                timer += 10;
            } else {
                timer += 1;
            }
        }

        while (idxB < booked.length) {
            answer[idxA++] = booked[idxB++][NAME];
        }

        while (idxU < unbooked.length) {
            answer[idxA++] = unbooked[idxU++][NAME];
        }

        return answer;
    }

    public int time(String[][] time, int idx) {
        return Integer.parseInt(time[idx][ARRIVAL].substring(0, 2)) * 60 + Integer.parseInt(time[idx][ARRIVAL].substring(3, 5));
    }
}
