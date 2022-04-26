package 일반알고리즘;

import java.util.Scanner;

public class 중복문자열제거 {
    public String solution(String str){
        String answer = "";
        //중복 문자열을 제거하자
        for(int i =0; i<str.length(); i++){
            //i번째 ,  i와  indexof(str.charAt(i)) 숫자가 같으면 처음, 다르면 이미 중복
            //System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)) );
            if(str.indexOf(str.charAt(i)) == i){
                // 같으면 처음이잖아
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String args[] ){
        중복문자열제거 T = new 중복문자열제거();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
