import java.util.*;

public  class test1 {
//6
//50 2
//20 1
//40 2
//60 3
//30 3
//30 1
    static class Node implements Comparable<Node>{
        public int money;
        public int time;
        public Node(int money, int time){
            this.money = money;
            this.time = time;
        }
        public int compareTo(Node o){
            //
            // money 순으로 정렬?
//            if(this.time == o.time) return o.money - this.money;
            //내림차순으로
            return o.time - this.time;
        }
    }

    static int n, max =Integer.MIN_VALUE;
    public int solution(ArrayList<Node> arr){
         int answer =0;
        // 거꾸로 넣기;
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
         // 정렬해주고
        Collections.sort(arr);
        // arr는 이미 정렬이 되어있는 상태 시간 내림차순으로
        int j=0;

        // 날이 큰게 max에 담아지고
        // 3일 걸려도 되는 일 , 2일 걸려도 되는 일 이렇게 시작임
        for(int i=max; i>=1; i--){
            // n은 몇개뽑을건지 그거구나
            for(; j<n; j++ ){
                // arr에서 뽑은 날짜가 i 보다 작으면 break
                // 3
                if(arr.get(j).time < i){
                    break;
                }else{
                    pq.offer(arr.get(j).money);
                }

            }
            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }

         return answer;
    }
    // 최대 스케줄
    public static void main(String[] args) {
        test1 T = new test1();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int money = sc.nextInt();
            int time = sc.nextInt();
            arr.add(new Node(money, time));
            if(time > max) max =time;
        }
        //
        System.out.println(T.solution(arr));

    }
}

