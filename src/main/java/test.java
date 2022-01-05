import java.util.*;

public class test {
    static int[] combi;
    static int n,m;

    public void DFS(int L, int s){
        if(L == m){
            //m 개 뽑는다 했을때
            for(int x : combi) System.out.print( x + " ");
            System.out.println();
        }else{
            for(int i=s; i<=n; i++){
                combi[L] = i;
                DFS(L+1,s+1);
            }
        }
    }

    public static void main(String[] args) {
        test T = new test();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        combi = new int[m];
        T.DFS(0,1);
    }

}