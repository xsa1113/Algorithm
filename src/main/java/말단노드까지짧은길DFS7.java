public class 말단노드까지짧은길DFS7 {
    static class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            data = val;
            lt = rt = null;
        }
    }
    Node root;
    public int DFS(int L , Node root){
        if(root.lt == null && root.rt == null) return L;
        else{
            return Math.min(DFS(L+1, root.lt),DFS(L+1,root.rt));
        }
    }

    public static void main(String[] args) {
        말단노드까지짧은길DFS7 tree = new 말단노드까지짧은길DFS7();
        tree.root = new 말단노드까지짧은길DFS7.Node(1);
        tree.root.lt = new 말단노드까지짧은길DFS7.Node(2);
        tree.root.rt = new 말단노드까지짧은길DFS7.Node(3);
        tree.root.lt.lt = new 말단노드까지짧은길DFS7.Node(4);
        tree.root.lt.rt = new 말단노드까지짧은길DFS7.Node(5);
        System.out.println(tree.DFS(0, tree.root));

    }
}
