import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거5 {
    public String solution(String str){
        String answer = "";
        Stack<Character> stack1 = new Stack<>();
        StringBuilder sb = new StringBuilder();

        //(A(BC)D)EF(G(H)(IJ)K)LM(N)
        //괄호 문자 제거하고 ( 면 push
        //) pop 괄호 안에 있는건 집어 넣지 말고

        for(char x : str.toCharArray()){
            if(x == ')'){
               while(stack1.pop() != '(');
            }else{
                stack1.push(x);
            }
        }

        for(int i =0; i<stack1.size(); i++){
            answer += stack1.get(i);
        }
//        int len = str.length();
//
//        for(int i =0; i<len; i++){
//                stack1.push(str.charAt(i));
//
//                if(str.charAt(i) == ')'){
//                    while(stack1.pop() == '('){
//                        break;
//                    }
//                }
//        }
//
//        while(stack1.isEmpty()){
//            sb.append(stack1.pop());
//        }
//        // ( A ( B C ) D )
//
//        answer = sb.toString();


        return answer;
    }
    public static void main(String[] args) {
        괄호문자제거5 T = new 괄호문자제거5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
