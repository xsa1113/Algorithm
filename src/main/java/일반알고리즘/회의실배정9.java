package 일반알고리즘;

import java.util.*;

public class 회의실배정9 {

    static class Node implements Comparable<Node>{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Node o){
            if(this.y == o.y) return this.x - o.x;
            return this.y - o.y;
        }
    }
    public int solution(int L, int n, ArrayList<Node> arr){
        int answer = 0;
        Collections.sort(arr);

        int et = 0;
        for(Node ob : arr ){
            if(ob.x >= et){
                answer++;
                et = ob.y;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        회의실배정9 T = new 회의실배정9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Node(s,e));
        }

        for(int i=0; i<n; i++){

        }
        System.out.println(T.solution(0,n, arr));
    }
}
