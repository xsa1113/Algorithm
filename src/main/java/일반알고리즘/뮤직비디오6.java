package 일반알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오6 {
    //9 3
    //1 2 3 4 5 6 7 8 9
    public int count(int [] arr, int capacity){
        int cnt=1, sum=0;
        for(int x : arr){
            if(sum + x > capacity){
                cnt++;
                sum=x;
            }
            else sum+=x;
        }

        return cnt;

    }
    public int solution(int n, int m , int[] arr){
        int answer =0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt){
            int mid =(lt+rt)/2; // 일단 미드로 시작해서 이거 가능해? 이런느낌
            if(count(arr,mid)<=m) { // 이거m 장수로 가능해?
                answer = mid;
                rt = mid -1;
            }else{
                // 이 용량으로 안됨
                lt = mid +1;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        뮤직비디오6 T = new 뮤직비디오6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n,m,arr));
    }

}
