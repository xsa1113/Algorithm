import java.util.Scanner;
import java.util.Stack;

public class 후위식연5 {
    public int solution(String str){
        int answer = 0;
        int res = 0;
        int len = str.length();
        Stack<Integer> stack = new Stack<>();

        // charcter Integer 48 부터 시작
        // charAt - '0' 을 하면 이니까 아아ㅏ아아하하하;;

        for(char x : str.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(x-48);
            }else{
              int rt = stack.pop();
              int lt = stack.pop();
              if(x == '+'){
                  stack.push(lt + rt);
              }else if(x == '*'){
                  stack.push(lt * rt);
              }else if(x == '-'){
                  stack.push(lt - rt);
              }else if(x == '/'){
                  stack.push(lt / rt);
              }
            }
        }

        answer = stack.get(0);


        return answer;
    }
    public static void main(String[] args) {
        후위식연5 T = new 후위식연5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }

}
