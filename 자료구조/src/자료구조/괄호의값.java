package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 괄호의값 {
	public static void main(String[] args) {
		// (()[[]])([])
		Scanner sc = new Scanner(System.in);
		String str = "";
		Stack<Character> stack = new Stack<>();
		
		str = sc.next();
		int result = 0;
		int mul =1;
		
		// () [] (x) [x]
		for(int i=0; i<str.length(); i++) {
			char tmp = str.charAt(i);
			switch (tmp) {
			case '(' : 
				stack.push('(');
			mul *=2 ;
			break;
			
			case '[' : 
				stack.push('[');
			mul *=3 ;
			break;
			
			case ')' : 
				if(stack.isEmpty() || stack.peek() != '(') result= 0;
					
			if(str.charAt(i-1) == '(') result+= mul;
			stack.pop();
			mul /= 2;
			break;
			
			case ']' :
				if(stack.isEmpty() || stack.peek() != '[') 
				result = 0;
			
			if(str.charAt(i-1) == '[') result +=mul;
				stack.pop();
				mul /= 3;
				
				break;
			}
		}
		System.out.println(!stack.isEmpty() ? 0 : result);
	}

}
