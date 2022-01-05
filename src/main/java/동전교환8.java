import java.util.Scanner;

public class 동전교환8 {
    static int n ,m;
    static int answer = Integer.MAX_VALUE;
    static int arr[];
    public void DFS(int L, int sum, int arr[]){
        // L은 동전의 개수 , 가지치기를 잘해야한다
        if(sum > m) return;
        if(L>=answer) return;
        if(sum == m){
            answer = Math.min(answer, L);
            return;
        }else{
            // 큰금액부터 하는게 좋다 동전
            for(int i=n-1; i>=0; i--){
                DFS(L+1, sum+arr[i], arr);
            }
        }
    }
    public static void main(String[] args) {
        동전교환8 T = new 동전교환8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 동전 종류 개수
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt(); // 동전의 종류
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
