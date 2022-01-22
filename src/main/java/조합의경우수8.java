import java.util.Scanner;

public class 조합의경우수8 {
    static int n,m;
    static int answer = 0;
    //오케
    //메모이제이션
    int[][] dy = new int[35][35];
    public int DFS(int n, int r){
        //메모이제이션
        if(dy[n][r] > 0){
            return dy[n][r];
        }
        if(n==r || r==0) return 1;
        else return dy[n][r]=DFS(n-1,r-1)+ DFS(n-1,r);
    }

    public static void main(String[] args) {
        조합의경우수8 T = new 조합의경우수8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 총개수
        m = sc.nextInt(); // m개 뽑는 경우의수
        System.out.println(T.DFS(n,m));
    }
}
