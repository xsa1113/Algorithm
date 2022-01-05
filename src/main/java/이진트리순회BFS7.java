import java.util.LinkedList;
import java.util.Queue;

public class 이진트리순회BFS7 {
    // 내부 클래스로 선언
    static class Node{
        int data;
        이진트리순회BFS7.Node lt, rt;
        public Node(int val){
            data = val;
            lt = rt = null;
        }
    }

    static Node root;
    public void BFS(Node root){

        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0 ;
        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L+" : ");

            // level 하나 진행함
            for(int i=0; i<len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data+" ");
                if(cur.lt!=null) Q.offer(cur.lt);
                if(cur.rt!=null) Q.offer(cur.rt);
            }
            // 레벨 증가 시켜줘야지
            L++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        이진트리순회BFS7 tree = new 이진트리순회BFS7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
