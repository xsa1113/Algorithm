import java.util.Scanner;

public class 경로탐색DFS7 {
    // 경우의 수 몇가지인지
    static int n,m, answer = 0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n){
            answer++;
        }else{
            for(int i=1; i<=n; i++){
                if(graph[v][i]==1 && ch[i] == 0){
                    ch[i] = 1; // 방문 체크
                    DFS(i); // v->i 로 이동하는 거니까
                    ch[i] = 0; // 백하면서 취소하고 돌아가기
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색DFS7 T = new 경로탐색DFS7();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        ch=new int[n+1];
        for(int i =0; i<m; i++){
            // 방향그래프
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] =1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);

    }
}
