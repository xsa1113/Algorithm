package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 트리순회 {
    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();
    //전위 중위 후위
    //전위 root 탐색
    //중위 left 탐색
    //후위 right 탐색
    static class Node{
        int left;
        int right;

        public Node(int left, int right){
            this.right = right;
            this.left = left;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        // list 배열
        for(int i=1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<n+1; i++){
            //1번 부터 시작이니까
            String[] line = br.readLine().split(" ");
            int data = line[0].charAt(0) - 'A'+1;
            System.out.println("data : " +   data);
            int left = line[1].charAt(0) - 'A'+1;
            System.out.println("left : " +  left);
            int right = line[2].charAt(0) - 'A'+1;
            System.out.println("right : " +  right);

            System.out.println("------------------");

            list[data].add(new Node(left, right));
        }

        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb.toString());
    }
    static void preorder(int start){
        for(Node node : list[start]){
            int l = node.left;
            int r = node.right;

            sb.append((char)(start+'A' -1));
            if(l!=-18) preorder(l);
            if(r!=-18) preorder(r);
        }
    }

    static void inorder(int start){
        for(Node node : list[start]){
            int l = node.left;
            int r = node.right;

            if(l != -18) inorder(l);
            sb.append((char)(start+'A' - 1));
            if(r != -18) inorder(r);
        }
    }

    static void postorder(int start){
        for(Node node : list[start]){
            int l = node.left;
            int r = node.right;

            if(l !=-18) postorder(l);
            if(r!=-18) postorder(r);
            sb.append((char)(start+'A' -1));
        }
    }


}
