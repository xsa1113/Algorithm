package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 후위식표기법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String str = "";
		int arr[] = new int[n];
		str = sc.next();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Double> operand = new Stack<>();
		int len = str.length();
		for(int i=0; i<len; i++) {
			char ch = str.charAt(i);
			if('A' <= ch && ch <= 'Z') {
				double d = arr[ch-'A'];
				operand.push(d);
			}else {
				double d1 = operand.pop();
				double d2 = operand.pop();
				double d3 = 0.0;
				switch (ch) {
				case '+' :
					d3 = d1 + d2;
					break;
				case '*' : 
					d3 = d1 * d2;
					break;
				case '-'  :
					d3 = d2 - d1;
					break;
				case '/' : 
					d3 = d2 / d1;
					break;
				}
				operand.push(d3);
			}
		}
		System.out.printf("%.2f", operand.pop());
	}

}
