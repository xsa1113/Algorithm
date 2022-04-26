package 일반알고리즘;

import java.util.Scanner;

public class 버블정렬6 {
    //6
    //13 5 11 7 23 15
    public int[] solution(int n , int[] arr){

        int idx = 0;

        for(int i=0; i<n-1; i++){
            for(int j=i; j<n-1-i; j++){
                if(arr[j]> arr[j+1]){
                    int tmp = arr[j];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        버블정렬6 T = new 버블정렬6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];

        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int x : T.solution(n, arr)){
            System.out.print(x + " ");
        }

    }
}
