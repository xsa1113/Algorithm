package 일반알고리즘;

import java.util.*;
public class 문자열압축 {
    public String solution(String str){
        String answer = "";
        str = str+" ";
        int cnt = 1;
        // 그이전까지만 가야한다
        for(int i =0; i<str.length()-1; i++){
            if(str.charAt(i)== str.charAt(i+1)) cnt++;
            else{
                answer += str.charAt(i);
                if(cnt>1){
                    // cnt 스트링
                    // Integer.toString()
                    answer += String.valueOf(cnt);
                    //1로 초기화해서 다시 하..
                    cnt = 1;
                }
            }

        }

        return answer;
    }
    public static void main(String[] args) {
        문자열압축 T = new 문자열압축();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }
}
