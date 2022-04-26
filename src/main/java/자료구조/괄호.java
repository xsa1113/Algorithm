package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			Stack<Character> stack = new Stack<>();
			String str = sc.next();
			 for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == '(') {
					stack.push(str.charAt(j));
				}else {
					int size = stack.size();
					if(size == 0) {
						// 아 넣어두고 empty가 아니다 라고 체크하기 
						stack.push(str.charAt(j));
						break;
					}else {
						stack.pop();
					}
				}
			
			}
			if(!stack.isEmpty()) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			
			
		}
		
		
		
	}

}
