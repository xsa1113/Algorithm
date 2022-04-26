package 일반알고리즘;

import java.util.Scanner;

public class 삽입정렬6 {
    //6
    //11 7 5 6 10 9

    public int[] solution(int n, int []arr){

        for(int i =1; i<n; i++){
            int tmp = arr[i];
            int j ;
            for(j=i-1; j>=0; j--){
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;

        }
        return arr;

    }

    public static void main(String[] args) {
        삽입정렬6 T = new 삽입정렬6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int x: T.solution(n, arr)){
            System.out.print(x + " ");
        }
    }
}
