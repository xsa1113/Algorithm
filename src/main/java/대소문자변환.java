import java.util.Scanner;

public class 대소문자변환 {
    public String solution(String str){
        String answer = "";

        // 아스키 넘버로도 가능 65~90 대문자
        // 소문자 97~122
        // 32를 빼면 대문자가 된다
        for(char x : str.toCharArray()){
            if(x>=97 && x<=122) answer+=(char) (x-32);
            else answer+= (char)(x+32);
        }


//        for(char x : str.toCharArray()){
//            if(Character.isLowerCase(x)){
//                //참이면 소문자 -> 대문자로
//                answer += Character.toUpperCase(x);
//            }else{
//                //대문자면 소문자로
//                answer += Character.toLowerCase(x);
//            }
//        }
        return answer;
    }
    public static void main(String[] args){
        대소문자변환 T = new 대소문자변환();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
