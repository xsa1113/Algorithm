import java.util.*;

public class 유효한팰린드롬 {
    public String solution(String str){
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)){
            answer = "YES";
        }
        return answer;

    }
    public static void main(String[] args) {
        유효한팰린드롬 T = new 유효한팰린드롬();
        Scanner sb = new Scanner(System.in);
        String str = sb.nextLine();
        System.out.println(T.solution(str));


    }
}
