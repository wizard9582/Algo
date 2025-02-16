package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q5639 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		while(br.ready()) {
			
			int num = Integer.parseInt(br.readLine());
			root = insertNode(root, num);
		}
		postOrder(root);
		System.out.println(sb);
	}
	
	static void postorder(Node n) {
		
		if(n == null) {
			return;
		}
		
		postorder(n.getLeft());
		postorder(n.getRight());
		sb.append(n.getValue()).append("\n");
	}
	
	public static class Node{
		Node left;
		Node right;
		int value;
		
		public Node(int value){
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		public void setLeft(Node n) {
			this.left = n;
		}
		public Node getLeft() {
			return this.left;
		}
		public void setRight(Node n) {
			this.right = n;
		}
		public Node getRight() {
			return this.right;
		}
	}
    public static Node insertNode(Node node, int N) {
        Node current = null;
        if(node == null) {
            return new Node(N);
        }
        
        if(node.getValue() > N) {
            current = insertNode(node.getLeft(), N);
            node.left = current;
        }else {
            current = insertNode(node.getRight(), N);
            node.right = current;
        }
        return node;
    }
    public static void postOrder(Node node) {
        if(node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            sb.append(node.getValue()).append("\n");
        }
    }
}
