package 일반알고리즘;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기5 {

    public int solution(String str){
        int answer = 0;
        int len = str.length();
        int lesor = 0;
        int stick = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        //()(((()())(())()))(())
        //(
        //)
        // ( 나왔을때만 stick의 갯수 카운트
        // ) 1. 이전이 (였으면 레이저
        // 2. 아니면 stick이 닫히는건데
        // 3. ( 이전의 스틱 갯수를 세기
        // 여는 괄호만 만낫을때 푸쉬

        for(int i=0; i<len; i++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
                stack2.push(str.charAt(i));
            }else{
                if(stack.peek() == '('){
                    stack2.pop();
                    answer += stack2.size();
                }else if(stack.peek() == ')'){
                    stack2.pop();
                    answer += 1;
                }
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        쇠막대기5 T = new 쇠막대기5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
