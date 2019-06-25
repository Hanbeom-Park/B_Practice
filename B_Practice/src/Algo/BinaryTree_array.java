
public class BinaryTree_array {
	static int number = 15;

	// 전위순회
	void preorder(int[] arr, int n) {
		if (n < number) {
			System.out.print(arr[n] + " ");
			preorder(arr, n * 2 + 1);
			preorder(arr, n * 2 + 2);
		}
	}

	// 중위순회
	void inorder(int[] arr, int n) {
		if (n < number) {
			inorder(arr, n * 2 + 1);
			System.out.print(arr[n] + " ");
			inorder(arr, n * 2 + 2);
		}
	}

	// 후위순회
	void postorder(int[] arr, int n) {
		if (n < number) {
			postorder(arr, n * 2 + 1);
			postorder(arr, n * 2 + 2);
			System.out.print(arr[n] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		BinaryTree_array bt = new BinaryTree_array();
		System.out.print("전위순회: ");
		bt.preorder(arr, 0);
		System.out.println("");

		System.out.print("중위순회: ");
		bt.inorder(arr, 0);
		System.out.println("");

		System.out.print("후위순회: ");
		bt.postorder(arr, 0);
		System.out.println("");
	}
}
