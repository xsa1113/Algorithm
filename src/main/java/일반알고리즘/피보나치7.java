package 일반알고리즘;

public class 피보나치7 {
    // 5를 예를들어서
    public int DFS(int n ){
        if(n == 1) return 1;
        else{
            return n*DFS(n-1);
        }
    }
    public static void main(String[] args) {
        피보나치7 T = new 피보나치7();
        System.out.println(T.DFS(5));
    }
}
