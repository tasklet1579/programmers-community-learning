package edu.programmers.practice.p100305;

import java.util.*;

// 코딩테스트 고득점 Kit
// 해시 Hash
public class Main {

    public static void main(String[] args) {
//        String[][] clothes = {{"yellowhat",  "headgear"},  {"bluesunglasses",  "eyewear"},  {"green_turban",  "headgear"}};
        String[][] clothes = {{"crowmask",  "face"},  {"bluesunglasses",  "face"},  {"smoky_makeup",  "face"}};
        System.out.println(new Solution().solution(clothes));
    }
}

// https://www.youtube.com/watch?v=gUOhIk-K1-o

// Hash는 Key : Value 형태의 자료구조
// Hash는 String을 기반으로 정보를 기록하고 관리해야 될 때 사용한다
// put get getOrDefault 메서드를 기억하자
class Solution {

    private Map<String,  Integer> hashMap = new HashMap();

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
