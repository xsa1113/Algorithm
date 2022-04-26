package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		Stack<Character> stack = new Stack<>();
		
		int result = 0;
		// 1. ( 시작하고 그다음이바로 ) 온다면 레이저
		// 2. ( 그다음이 (라면 막대기 
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push('(');
				continue;
			}
			if(str.charAt(i) == ')') {
				stack.pop();
				if(str.charAt(i-1) == '(') {
					// 레이
					result += stack.size();
				}else {
					result ++;
				}
			}
		}
		System.out.println(result);
	}

}
