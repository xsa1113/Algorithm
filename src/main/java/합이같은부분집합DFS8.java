import java.util.Scanner;

public class 합이같은부분집합DFS8 {
    static int n, arr[];
    static int total = 0;
    static String answer =  "NO";
    boolean flag = false;
    public void DFS(int L,int sum, int[] arr) {
        if(flag) return;
        if(sum>total/2) return;
        if(L == n){
            if((total-sum)==sum){
                answer = "YES";
                flag = true;
            }
        }else{
            DFS(L+1, sum + arr[L] , arr);
            DFS(L+1, sum , arr);
        }



    }
    public static void main(String[] args) {
        합이같은부분집합DFS8 T = new 합이같은부분집합DFS8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            total+=arr[i]; //total 전체를 알아주기
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);

    }
}
