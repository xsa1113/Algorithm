import java.util.Scanner;

public class 최대점수구하기DFS8 {
    static int n,m;
    static int score[];
    static int time[];
    static int answer = Integer.MIN_VALUE;
    public void DFS(int L, int sum, int sumtime, int [] score, int [] time){
        if(sumtime > m) return;
        if(L == n){
            answer = Math.max(answer, sum);
        }else{
            DFS(L+1, sum + score[L], sumtime + time[L], score, time);
            DFS(L+1, sum, sumtime, score, time);
        }
    }
    public static void main(String[] args) {
        최대점수구하기DFS8 T = new 최대점수구하기DFS8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 문제의 개수
        m = sc.nextInt(); // 제한 시간
        score = new int[n];
        time = new int[n];

        for(int i =0; i<n; i++){
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        T.DFS(0,0, 0, score,time);
        System.out.println(answer);
    }
}
