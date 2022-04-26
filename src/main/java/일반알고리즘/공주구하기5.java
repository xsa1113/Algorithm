package 일반알고리즘;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기5 {
    //1 2 3 4 5 6 7 8
    //  4 7 8
    // 3 6 1 5 2

    public int solution(int n, int k ){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;
        int flag = 1;

        for(int i =0; i<n; i++){

            queue.add(flag);
            flag++;
        }

        while(queue.size() > 1){
            int tmp = queue.poll();
            queue.add(tmp);
            cnt++;

            if(cnt == k){
                queue.poll();
                cnt = 1;
            }

        }
        answer = queue.poll();

        return answer;
    }
    public static void main(String[] args) {
        공주구하기5 T = new 공주구하기5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(T.solution(n, k));
    }
}
