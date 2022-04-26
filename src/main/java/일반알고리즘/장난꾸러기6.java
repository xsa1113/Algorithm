package 일반알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기6 {
    //9
    //120 125 152 130 135 135 143 127 160
    // arraylist로 반환받아서 해도됨 그게 더 깔끔한듯

    public int[] solution(int n , int[] arr){
        int [] answer = new int[2];
        int [] tmp = new int[n];
        boolean flag = true;

        // 복사
        for(int i=0; i<n; i++){
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp);

        int idx = 0;
        for(int i=0; i<n; i++){
            if(tmp[i] != arr[i]){
                idx = i;
                if(flag){
                    answer[0] = idx + 1;
                    flag = false;
                }else{
                    answer[1] = idx + 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        장난꾸러기6 T = new 장난꾸러기6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i =0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        for(int x : T.solution(n,arr)){
            System.out.print(x + " ");
        }

    }
}
