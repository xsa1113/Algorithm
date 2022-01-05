import java.util.LinkedList;
import java.util.Queue;

public class 말단노드까지짧은길BFS7 {
    Node root;
    public int BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                Node cur = queue.poll();
                //cur 말단 노드인지 확인해보기
                if(cur.lt == null && cur.rt == null){
                    return L;
                }
                if(cur.lt != null) queue.offer(cur.lt);
                if(cur.rt != null) queue.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }
    static class Node{
        int data;
        말단노드까지짧은길BFS7.Node lt, rt;
        public Node(int val){
            data = val;
            lt = rt = null;
        }
    }


    public static void main(String[] args) {
        말단노드까지짧은길BFS7 tree = new 말단노드까지짧은길BFS7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));


    }
}
