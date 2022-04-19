package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 이진트리_5639 {
	//the end
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		String a ="";
		while(true) {
			a =br.readLine() ;
			if(a == null || a.equals("") ) {
				break;
			}
			root.insert(Integer.parseInt(a));
		}
		
		postorder(root);
	}
	

	static class Node{
		int num;
		Node left, right;
		public Node(int num) {
			this.num = num;
		}
		public Node() {
			this.num = num;
			this.left = left;
			this.right = right;
		}
		
		void insert(int n) {
			if(n<this.num) {
				if(this.left == null) {
					this.left=new Node(n);
				}else {
					this.left.insert(n);
				}
			}else {
				if(this.right == null) {
					this.right = new Node(n);
				}else {
					this.right.insert(n);
				}
			}
			
			
		}
	}
	static void postorder(Node node){
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.num);
	}
	
	
}
