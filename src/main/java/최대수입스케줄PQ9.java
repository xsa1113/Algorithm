import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최대수입스케줄PQ9 {
    // 먼저 정렬을 한다
    // 날짜는 N일 안에 하면 되는 거임
    static class Node implements Comparable<Node>{
        public int money;
        public int time;
        Node(int money, int time){
            this.money = money;
            this.time = time;
        }
        @Override
        public int compareTo(Node ob){
            return ob.time - this.time;
            // 내림 차순
        }
    }
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Node> arr){
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //collections.reverseOrder 가 없으면 최소값을 우선순위로 저장
        Collections.sort(arr); //날짜가 큰거부터 정렬
        int j=0;
        for(int i=max; i>=1; i--){
            // 날짜가 하루씩적어진다
            // j 초기화 x
            for( ; j<n; j++){
                if(arr.get(j).time < i){
                    break;
                }else{
                    // 강연료를 넣어주라
                    pq.offer(arr.get(j).money);
                }
            }
            if(!pq.isEmpty()){
                // 할 수 있는 날에 제일 큰돈을 골라서 하겠다
                answer += pq.poll();
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        최대수입스케줄PQ9 T = new 최대수입스케줄PQ9();
        Scanner sc = new Scanner(System.in);
        ArrayList<Node> arr = new ArrayList<>();
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            int money = sc.nextInt();
            int day = sc.nextInt();
            arr.add(new Node(money, day));
            // max 날짜를 가지고 있자
            if(day > max ) max = day;
        }
        System.out.println(T.solution(arr));

    }
}
