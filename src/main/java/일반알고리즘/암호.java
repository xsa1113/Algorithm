package 일반알고리즘;

import java.util.*;
public class 암호 {
    public String solution(int n, String str){
        String answer = "";
        //총 n번, 7번씩 돌면된다.
        //돌때마다 # -> 1로
        //* -> 0으로 변환
        //나온값을 binary함수 이용해서 10진수로 변환
        //그걸 다시 아스키코드로 변환하고
        //StringBuilder를 이용해서
        //붙여서 진행

        // 와 쉽게 replace로도 가능하겠네;;
        //4
        //#****###**#####**#####**##**

        for(int i =0; i<n; i++){
            //substring
            String tmp = str.substring(0,7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(tmp,2); //2는 2진수
            //cast char로
            answer += (char)num;

            System.out.println(tmp + " " + num);
            str = str.substring(7);

        }

        return answer;

    }
    public static void main(String[] args) {
        암호 T = new 암호();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n,str));
    }
}
