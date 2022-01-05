import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 등수구하기2 {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();

        int cnt = 1;
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                else{
                    if(arr[i] <= arr[j]){
                        cnt++;
                    }
                }
            }
            answer.add(cnt);
            cnt = 1;
        }

        return answer;

    }

    public static void main(String[] args) {
        등수구하기2 T = new 등수구하기2();
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
