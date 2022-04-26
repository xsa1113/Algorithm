package 일반알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색6 {
    //8 32
    //23 87 65 12 57 32 99 81
    public int solution(int n,int sel, int[] arr){
        int answer = 0;
        int middle = n/2;
        Arrays.sort(arr);

        if(arr[middle] < sel){
            for(int i = middle; i<n; i++){
                if(arr[i] == sel){
                    answer = i+1;
                }
            }
        }else if(arr[middle] > sel){
            for(int i = middle; i>=0; i--){
                if(arr[i] == sel){
                    answer = i+1;
                }
            }

        }else if(arr[middle] == sel){
            answer = middle +1;
        }
        return answer;
    }
    public static void main(String[] args) {
        이분검색6 T = new 이분검색6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sel = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n,sel, arr));
    }
}
