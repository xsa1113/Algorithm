package 일반알고리즘;

import java.util.Scanner;

public class 선택정렬6 {
    // 오름차순 정도
    public int[] solution(int n, int [] arr){
        //6
        //13 5 11 7 23 15
        for(int i =0; i<n-1; i++){
            int idx = i;
            for(int j=i+1; j<n; j++){
                if(arr[idx] > arr[j]){
                   idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        선택정렬6 T = new 선택정렬6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int x : T.solution(n,arr)){
            System.out.print(x + " ");
        }


    }
}
