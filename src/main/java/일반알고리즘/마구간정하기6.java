package 일반알고리즘;

import java.util.Scanner;

public class 마구간정하기6 {
    public int solution(int n , int m , int [] arr){
        int answer = 0;


        return answer;

    }

    public static void main(String[] args) {
        마구간정하기6 T = new 마구간정하기6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 마구간
        int m = sc.nextInt(); // C마리의 말
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n,m,arr));
    }
}
