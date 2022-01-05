import java.util.Scanner;

public class 중복순열구하기8 {
    static int[] pm;
    static int n, m;
    public void DFS(int L){
        if(L==m){
            for(int x : pm) System.out.print(x+" ");
            System.out.println();
        }else{
            // 다섯가닥 5번의 호출이 일어남
            for(int i =1; i<=n; i++){
                pm[L] = i;
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) {
        중복순열구하기8  T = new 중복순열구하기8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        T.DFS(0);

    }
}
