package 일반알고리즘;

import java.util.*;

public class 문자찾기 {
    // 대소문자 생각하지 않고
    // 다받아서 갯수 카운트
    public static int solution(String str, char t){
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        System.out.println(str);
        System.out.println(t);

//        for(int i =0; i<str.length(); i++){
//            if(str.charAt(i) == t){
//                answer++;
//            }
//        }
        //for each
        //문자배열 객체 만듬
        for(char x : str.toCharArray()){
            if(x == t){
                answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        문자찾기 T = new 문자찾기();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);


        System.out.println(문자찾기.solution(str,c));
    }
}
