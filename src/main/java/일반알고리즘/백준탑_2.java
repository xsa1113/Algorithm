package 일반알고리즘;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 백준탑_2 {
    //6 9 5 7 4
    //수평으로 한다
    static int n,idx;
    static ArrayList<Node> arr;
    static int[] answer ;
    static Stack<Node> stack;
    boolean flag;
    static class Node{
        // 높이 위치
        int height;
        int position;
        public Node(int height, int position){
            this.height = height;
            this.position = position;
        }
    }
    public void solution(){
        // arraylist에 있는 포지션대로 오른쪽으로부터
        // 가장 높은 탑을 stack에 쌓으면서 진행
        //
        stack = new Stack<>();
        //4 < 7
        //7
        for(int i=n-1; i>=0; i--){
            flag = true;
           loop: for(int j=i-1; j>=0; j--){
                if(i == n-1){
                    if(arr.get(i).height <= arr.get(j).height){
                        //arraylist에 잇으니까 돌면서 만약에 j가 크다 그러면 answer에 넣어주기
//                        stack.push(new Node(arr.get(j).height, arr.get(j).position));
                        answer[i] = arr.get(j).position;
                        flag = false;
                    }
                }else{
                    // 처음이 아니라면 계속 스택에서 비교하면 끝
                    if(arr.get(i).height <= arr.get(j).height){
                        // 포지션을 넣어주고
//                        stack.pop();
//                        stack.push(new Node(arr.get(j).height, arr.get(j).position));
                        answer[i] = arr.get(j).position;
                        flag = false;
                        break loop;
                    }

                }
            }
            if(!flag){
                answer[i] = 0;
            }

        }
    }
    public static void main(String[] args) {
        백준탑_2 T = new 백준탑_2();
        Scanner sc = new Scanner(System.in);
        // arryList에 일단 담자
        n = sc.nextInt();
        arr = new ArrayList<>();
        idx = 0;
        answer = new int[n];
        for(int i=0; i<n; i++){
            int height = sc.nextInt();
            arr.add(new Node(height,idx));
            idx++;
        }
        T.solution();

        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }

    }
}
