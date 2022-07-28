package edu.programmers.practice.p100305;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        String[][] clothes = {{"yellowhat",  "headgear"},  {"bluesunglasses",  "eyewear"},  {"green_turban",  "headgear"}};
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(new Solution().solution(clothes));
    }
}

class Solution {

    private Map<String, Integer> hashMap = new HashMap();

    public int solution(String[][] clothes) {
        int answer = 1;

        for (String[] clothe : clothes) {
            hashMap.put(clothe[1], hashMap.getOrDefault(clothe[1], 1) + 1);
        }

        for (int count : hashMap.values()) {
            answer *= count;
        }

        return answer - 1;
    }
}
