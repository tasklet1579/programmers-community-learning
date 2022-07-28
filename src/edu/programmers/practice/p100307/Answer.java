package edu.programmers.practice.p100307;

import java.util.Stack;

public class Answer {
    /*
    * 문제 이해
    * 입력값으로 괄호 쌍의 개수가 주어지고
    * 괄호의 조합들 중에서 올바르게 닫힌 괄호는 몇 개인지 구하라
    * 모든 경우를 확인하면서 조건에 해당하는 경우 카운팅 한다
    *
    * 문제 설계
    * 열리는 괄호를 배치한다
    * 그 이후에 닫히는 괄호를 배치한다
    * 괄호는 N개 이상 사용할 수 없다
    * 열리기 전에는 닫히는 괄호를 사용할 수 없다
    * 닫히는 괄호의 개수가 열리는 괄호 개수보다 클 수 없다
    */
    public int solution(int n) {
        int answer = 0;

        Stack<P> stack = new Stack<>();
        stack.push(new P(0, 0));
        while (!stack.isEmpty()) {
            P p = stack.pop();
            if (p.open > n) {
                continue;
            }
            if (p.open < p.close) {
                continue;
            }
            if (p.open + p.close == 2 * n) {
                answer++;
                continue;
            }
            stack.push(new P(p.open + 1, p.close));
            stack.push(new P(p.open, p.close + 1));
        }
        return answer;
    }

    static class P {
        private int open, close;

        public P(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }
}
