import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 결혼식9 {

    static class Node implements Comparable<Node>{
        public int time;
        public char state;
        public Node(int time, char state){
            this.time = time;
            this.state = state;
        }
        @Override
        public int compareTo(Node o){
            // 시간이 같으면 state 기준으로
            if(o.time == this.time) return this.state- o.state;
            // 아니면 가는시간으로 오름
            else return this.time - o.time;
        }
    }
    public int solution(ArrayList<Node> arr){

        int max = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for(Node ob : arr){
            if(ob.state == 's') cnt ++;
            else cnt--;
            max = Math.max(max, cnt);
        }
        return max;
    }
    public static void main(String[] args) {
        결혼식9 T = new 결혼식9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Node(s, 's'));
            arr.add(new Node(e, 'e'));
        }
        System.out.println(T.solution(arr));
    }
}
