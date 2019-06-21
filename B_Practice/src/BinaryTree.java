

public class BinaryTree<T> {
	private TreeNode<T> root;
	private TreeNode<T> find_node;
	public static void main(String[] args) {
		BinaryTree<Integer> b=new BinaryTree<>(1);
		b.input(1,2);
		b.input(1,3);
		b.input(2,4);
		b.input(3,5);
		b.input(3,6);
		b.input(4,7);
		b.input(5,8);
		b.input(5,9);
		b.input(6,10);
		b.input(6,11);
		b.input(7,12);
		b.input(11,13);
		
		b.preorder();
		
	}

	public BinaryTree(T data) {
		root=new TreeNode<T>(data);
		
	}
	
	public void input(T parent,T kid) {
		search(root,parent);
		TreeNode<T> newNode = new TreeNode<>(kid);
		if(find_node.data==null) {
			return;
		}
		if(find_node.left==null) {
			find_node.left=newNode;
		}else if(find_node.right==null) {
			find_node.right=newNode;
		}
	}
	private void search(TreeNode<T> n,T data) {
		
		if(n.data==data) {
			find_node=n;
			return;
		}
		
		if (n.left != null) {
			search(n.left, data);
		}
		if (n.right != null) {
			search(n.right, data);
		}

	}
	private void preorder(TreeNode<T> n) {
		System.out.print(n.data+" ");
		if (n.left != null) {
			preorder(n.left);
		}
		if (n.right != null) {
			preorder(n.right);
		}
	}
	public void preorder() {
		preorder(root);
	}
	public class TreeNode<E> {
		E data;
		TreeNode<E> left;
		TreeNode<E> right;

		TreeNode(E data) {
			this.data = data;
			left = null;
			right = null;

		}
	}

}
