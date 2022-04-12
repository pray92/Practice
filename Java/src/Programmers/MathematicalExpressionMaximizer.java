package Programmers;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

// 20:18 ~ 22:05
public class MathematicalExpressionMaximizer {

    final private int PLUS = 0;
    final private int MINUS = 1;
    final private int MULTI = 2;
    // 해커톤 개최, 다음과 같은 방식으로 상금 지급
    // +, -, *로 이뤄진 연산 수식이 주어짐
    // 전닯다은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출
    // 연산자의 우선 순위는 같을 수 없음
    // 계산 결과가 음수라면 절댓값으로 변환함
    // 가장 상금의 참가자가 우승
    public long solution(String expression) {
        long answer = 0;

        // 우선순위 부여 방식
        int[][] priorities = new int[][]{
            new int[]{1, 2, 3},
            new int[]{1, 3, 2},
            new int[]{2, 1, 3},
            new int[]{2, 3, 1},
            new int[]{3, 1, 2},
            new int[]{3, 2, 1},
        };
        // 후위 연산을 통한 계산
        for(int[] priority : priorities){
            answer = Math.max(answer, getReward(expression, priority));
        }
        // answer와 비교해서 가장 큰 값을 초기화

        return answer;
    }

    private long getReward(String expression, int[] priority){

        List<String> postCalc = new ArrayList<String>();
        Stack<Character> stack = new Stack<Character>(); 

        StringBuilder strNumber = new StringBuilder();
        for(int i = 0; i < expression.length(); ++i){
            char exp = expression.charAt(i);

            // 낮은 것이 더 높음
            // 우선순위가 높거나 같다면 스택 연산자 pop, calc 추가하고 현재 연산자 push
            // 그 외엔 현재 연산자 push
            switch(exp){
                case '*':{
                    postCalc.add(strNumber.toString());
                    strNumber = new StringBuilder();

                    while (!stack.empty() && priority[MULTI] <= getPriority(stack.peek(), priority)){
                        postCalc.add(stack.pop().toString());
                    }

                    stack.add(exp);
                } break;
                case '-':{
                    postCalc.add(strNumber.toString());
                    strNumber = new StringBuilder();
                    
                    while (!stack.empty() && priority[MINUS] <= getPriority(stack.peek(), priority)){
                        postCalc.add(stack.pop().toString());
                    }

                    stack.add(exp);
                } break;
                case '+':{
                    postCalc.add(strNumber.toString());
                    strNumber = new StringBuilder();
                
                    while (!stack.empty() && priority[PLUS] <= getPriority(stack.peek(), priority)){
                        postCalc.add(stack.pop().toString());
                    }

                    stack.add(exp);
                } break;
                default:{
                    strNumber.append(exp);
                } break;
            }
        }

        if(0 < strNumber.length()){
            postCalc.add(strNumber.toString());
        }
        while(!stack.empty()){
            postCalc.add(stack.pop().toString());
        }

        return Math.abs(calculate(postCalc));
    }

    private int getPriority(char exp, int[] priority){
        switch(exp){
            case '*': return priority[MULTI];
            case '-': return priority[MINUS];
            case '+': return priority[PLUS];
        }

        return -1;
    }

    private Long calculate(List<String> postCalc){
        
        Stack<Object> stack = new Stack<Object>();
        for(String exp : postCalc){
            if(exp.equals("+")){
                Long num2 = (Long)stack.pop();
                Long num1 = (Long)stack.pop();
                stack.add(num1 + num2);
            } else if(exp.equals("-")){
                Long num2 = (Long)stack.pop();
                Long num1 = (Long)stack.pop();
                stack.add(num1 - num2);
            } else if(exp.equals("*")){
                Long num2 = (Long)stack.pop();
                Long num1 = (Long)stack.pop();
                stack.add(num1 * num2);
            } else{
                stack.add(Long.parseLong(exp));
            }
        }

        Long ret = (Long)stack.pop();
        return ret;
    }

    public static void main(String[] args){
        new MathematicalExpressionMaximizer().solution("100-200*300-500+20");
    }
}
