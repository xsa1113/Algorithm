import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호5 {
    public String solution(String str){
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        int len = str.length();

        for(char x : str.toCharArray()){
            if(x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            return "NO";
        }
        return answer;
    }
    public static void main(String[] args) {
        올바른괄호5 T = new 올바른괄호5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
