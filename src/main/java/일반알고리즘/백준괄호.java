package 일반알고리즘;

import java.util.*;
public class 백준괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		Stack<Character> stack = new Stack<>();
		
		String answer;
	
		for(int i=0; i<a; i++) {
			String str = sc.next();
			int len = str.length();
			 
			answer = "NO";
			
			loop : for(int j=0; j<len; j++) {
				if(str.charAt(i) == '(') {
					stack.push(str.charAt(i));
				}else {
					if(stack.isEmpty()) {
						System.out.println(answer);
						break loop;
					}else {
						stack.pop();
					}
				}
				
					
			}
			if(!stack.isEmpty()) {
				System.out.println(answer);
			}else {
				answer = "YES";
				System.out.println(answer);
			}
		
		}
	}
}
