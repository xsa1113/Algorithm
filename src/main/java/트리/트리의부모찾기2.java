package 트리;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;



public class 트리의부모찾기2 {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 노드의 개수

        list = new ArrayList[n+1];
        parents = new int[n+1];
        check = new boolean[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=1; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 인접 리스트 생성
            list[a].add(b);
            list[b].add(a);
        }

        for(int k=1; k<=n; k++){
            //1번 부터 시작이니까
            if(!check[k]){
                dfs(k);
            }
        }
        for(int i=2; i<=n; i++){
            // print
            System.out.println(parents[i]);
        }

    }

    private static void dfs(int v){
        // 정점 부터 시작
        if(check[v]){
            return;
        }
        check[v] = true;
        for(int vv: list[v]){
            if(!check[vv]){
                parents[vv] = v;
                dfs(vv);
            }
        }
    }
}
