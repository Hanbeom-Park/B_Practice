
public class BinaryTree {
	static class TreeNode {
		private Object data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(Object data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public Object getData() {
			return this.data;
		}
	}

	private TreeNode root;

	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
		TreeNode root = new TreeNode(data);
		root.left = bt1;
		root.right = bt2;
		return root;
	}

	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		TreeNode n7 = tree.makeBT(null, 'D', null);
		TreeNode n6 = tree.makeBT(null, 'C', null);
		TreeNode n5 = tree.makeBT(null, 'B', null);
		TreeNode n4 = tree.makeBT(null, 'A', null);
		TreeNode n3 = tree.makeBT(n6, '/', n7);
		TreeNode n2 = tree.makeBT(n4, '*', n5);
		TreeNode n1 = tree.makeBT(n2, '-', n3);

		System.out.print("\nPreorder : ");
		tree.preorder(n1);

		System.out.print("\nInorder : ");
		tree.inorder(n1);

		System.out.print("\nPostorder : ");
		tree.postorder(n1);
	}
}
