import java.util.Scanner;

public class 수열추측하기8 {
    static int n,m;
    static int[] b,p,ch;
    boolean flag = false;
    int[][] dy = new int[35][35];
    // 조합도 필요 순열도 필요
    // 파스칼의 삼각형
    public int combi(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1 ;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public void DFS(int L, int sum){
        if(flag) return; // 스택에 쌓여있는 것들 중간에 답을 찾으면 그냥 다 리턴 시켜버리기
        if(L==n){
            if(sum == m){
                for(int x: p) System.out.print(x + " ");
                flag = true;
            }

        }else{
            for(int i=1; i<=n; i++){
                if(ch[i] == 0){
                    //index가 아니라 i가 순열을 만드는 자체임
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L+1, sum+(p[L]*b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        수열추측하기8 T = new 수열추측하기8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch= new int[n+1];
        for(int i=0; i<n; i++){
            b[i] = T.combi(n-1,i);
        }
        T.DFS(0,0);
    }
}
