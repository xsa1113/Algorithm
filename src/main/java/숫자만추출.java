
import java.util.*;

public class 숫자만추출 {
    public int solution(String str){
        String answer = "";

        //character 숫자 48(0) ~ 57 (9)

        /**
         *
         * 1 sol
         * for(char x : str.toCharArray()){
         *             if(x>=48 && x<=57){
         *                 answer = answer * 10 + (x-48);
         *             }
         *         }
         */

        /**
         * sol2
         * */
        for(char x : str.toCharArray()){
            if(Character.isDigit(x)) answer+=x;
        }

        return Integer.parseInt(answer);


    }
    public static void main(String[] args) {
        숫자만추출 T = new 숫자만추출();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }
}
