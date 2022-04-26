package 일반알고리즘;

import java.util.*;
public class 문자열프로그래머스 {



        // 1. 실패율이 같을 경우 스테이지가 작은 번호 우선
        // 2. 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율 0
        static class Node implements Comparable<Node>{
            double rate;
            int idx;
            public Node(int idx, double rate ){
                this.idx = idx;
                this.rate = rate;
            }
            @Override
            public int compareTo(Node o){
                if(this.rate > o.rate){
                    return -1;
                }else if(this.rate < o.rate){
                    return 1;
                }else{
                    return 0;
                }

            }

        }
        public int[] solution(int N, int[] stages) {

            int[] users = new int[N+2]; // 1부터 시작
            for(int n : stages){
                users[n] ++;
            }
            // 총인원
            int pass_user = stages.length;
            List<Node> rate = new ArrayList<>();

            for(int i=1; i<=N; i++){
                rate.add(new Node(i,(double)users[i] / pass_user));
                pass_user -= users[i];
            }
            // 내림차순으로
            Collections.sort(rate);
            int[] answer = new int[N];
            for(int i=0; i<N; i++){
                answer[i] = rate.get(i).idx;
            }

            return answer;
        }

}
