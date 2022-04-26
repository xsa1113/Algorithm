package 일반알고리즘;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 백준탑_2493 {
    static int n;
    static ArrayList<Node> top;
    static Stack<Node> stack;
    static boolean flag;

    static class Node{
        int idx;
        int height;
        public Node(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt(); //  n
        top = new ArrayList<>();
         // 제일 높은 건물을 선택해서 넣고
        // answer idx 를 찾아서 넣기
        int answer[] = new int[n + 1];
        int idx = 1;
        for(int i=0; i<n; i++){
            int height = sc.nextInt();
            top.add(new Node(idx,height));
            idx++;
        }
        // top 에서 반대로 돌면서 확인하기
        stack = new Stack<>(); // 스택 계쏙 초기화 해주고
        // 5번만 돌면된다.



        for(int i=n-1; i>=0; i--){
            Node tmp = top.get(i); // top 에 있는 걸 뺴서
            stack.push(tmp);


            flag = false;
            loop : for(int j=i-1; j>=0; j--){
                Node tmp2 = top.get(j);
                if(tmp2.height >= stack.peek().height){
                    stack.pop();
                    stack.push(tmp2);
                    answer[i+1] = tmp2.idx;
                    flag = true;
                    break loop;
                }
                    // 아니면 그냥 넘어간다
            }
            if(!flag){
                answer[i+1] = 0;
            }
        }

        for(int i=1; i<answer.length; i++){
            System.out.print(answer[i] +  " ");
        }

    }
}
