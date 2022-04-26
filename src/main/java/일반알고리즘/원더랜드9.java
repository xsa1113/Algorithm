package 일반알고리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 원더랜드9 {
    // 크루스칼 알고리즘
    public static class Edge implements Comparable<Edge>{
        public int v1;
        public int v2;
        public int cost;
        Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        //그리디로 인해 오름차순 정렬을 한다 작은것부터 쭊쭊
        @Override
        public int compareTo(Edge ob){
            return this.cost-ob.cost;
        }
    }
    static int unf[];
    static int answer;
    public static int find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa == fb) unf[fa] = fb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        ArrayList<Edge> arr = new ArrayList<>();
        for(int i=0; i<=n; i++) unf[i] = i;
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge(a,b,c));
        }
        answer =0;
        Collections.sort(arr);
        for(Edge ob : arr){
            int fv1=find(ob.v1);
            int fv2=find(ob.v2);
            if(fv1 != fv2){
                answer += ob.cost; //cost 를 누적하기
                union(ob.v1,ob.v2);
            }
        }
        System.out.println(answer);

    }
}
