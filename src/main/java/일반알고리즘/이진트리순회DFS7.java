package 일반알고리즘;

public class 이진트리순회DFS7 {
    static class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            data = val;
            lt = rt = null;
        }
    }
    Node root;
    public void DFS(Node root){
        // 말단 노드로 왔을때 바로 return
        if(root==null) return;
        else {
            // 왼쪽
//            System.out.print(root.data+" "); // 여기에 하면 전위 순회가 된다
            DFS(root.lt);
//            System.out.print(root.data+" "); // 여기에 하면 중위 순회가 된다
            //오른쪽
            DFS(root.rt);
            System.out.print(root.data + " "); // 여기에 하면 후위 순회가 된다
        }

    }
    public static void main(String[] args) {
        이진트리순회DFS7 tree= new 이진트리순회DFS7();
        tree.root=new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);


    }
}
