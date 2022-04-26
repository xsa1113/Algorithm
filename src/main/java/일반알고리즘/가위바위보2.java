package 일반알고리즘;

import java.util.*;
public class 가위바위보2 {
    public String solution(int n, int[] a, int[] b){
        String answer = "";

        for(int i=0; i<n; i++){
            //가위 1, 바위 2, 보 3
            //
            if(a[i] == 1){
                if(b[i] == 1){
                    answer += "D";
                }else if(b[i] == 2){
                    answer += "B";
                }else if(b[i] ==3){
                    answer += "A";
                }
            }else if(a[i] == 2){
                if(b[i] == 1){
                    answer += "A";
                }else if(b[i] == 2){
                    answer += "D";
                }else if(b[i] ==3){
                    answer += "B";
                }

            }else if(a[i] == 3){
                if(b[i] == 1){
                    answer += "B";
                }else if(b[i] == 2){
                    answer += "A";
                }else if(b[i] ==3){
                    answer += "D";
                }
            }

        }

        return answer;

    }
    public static void main(String[] args) {
        가위바위보2 T = new 가위바위보2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }


        for(char x : T.solution(n,a,b).toCharArray())
            System.out.println(x);



    }
}
