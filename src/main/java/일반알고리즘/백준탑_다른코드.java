package 일반알고리즘;

import java.util.Scanner;
import java.util.Stack;

public class 백준탑_다른코드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<int[]> stack = new Stack<>();

        for(int i=1; i<=n; i++){
            int top = sc.nextInt();
            while(!stack.isEmpty()){
                if (stack.peek()[1] >= top) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }
            stack.push(new int[] {i, top});
        }
    }
}
