package 일반알고리즘;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {



    public ArrayList<String> solution(int n, String[] str){

        ArrayList<String> answer = new ArrayList<>();
        //stringbuilder -> reverse
//        for(String x : str){
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }

        // 원하는것만 특정하게 바꾸는 법
        // 왼쪽 , 오른쪽 변
        for(String x : str){
            // x가 갖는걸 char로
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() -1;
            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt ++;
                rt --;
            }
            //valueOf -> s라는 문자를 string화 시켜준다
            String tmp = String.valueOf(s);
            answer.add(tmp);

        }


        return answer;

    }
    public static void main(String args[]){
        단어뒤집기 T = new 단어뒤집기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s= new String[n];
        for(int i =0; i<n; i++){
            s[i] = sc.next();
        }
        for(String x : T.solution(n, s)){
            System.out.println(x);
        }
    }
}
