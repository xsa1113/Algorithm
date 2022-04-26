package 일반알고리즘;

import java.util.*;
public class 큰수출력하기2 {
    public ArrayList<Integer> solution(int n , int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i =1; i<arr.length; i++){
            if(arr[i-1] < arr[i]){
                answer.add(arr[i]);
            }
        }

        return answer ;

    }
    public static void main(String[] args) {
        큰수출력하기2 T = new 큰수출력하기2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(N,arr)){
            System.out.print(x+" ");
        }

    }
}
