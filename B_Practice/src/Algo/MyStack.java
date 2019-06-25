public class MyStack<T> {
	private Node<T> top;

	public static void main(String[] args) {
		MyStack<Integer> a = new MyStack<>();
		a.push(200);
		a.push(260);
		a.push(400);
		a.push(200);
		a.push(250);
		a.push(100);
		a.push(300);
		while (!a.isEmpty()) {
			System.out.println(a.pop());
		}
		a.push(345);
		a.push(678);
		a.push(456);
		a.push(123);
		while (!a.isEmpty()) {
			System.out.println(a.pop());
		}

	}

	public MyStack() {
		top = new Node<T>(null);

	}

	public void push(T data) {
		Node<T> newNode = new Node<T>(data);

		newNode.nextNode = top.nextNode;
		top.nextNode = newNode;

	}

	public T pop() {
		T tmp = (T) top.nextNode.data;
		top.nextNode = top.nextNode.nextNode;
		return tmp;
	}

	public boolean isEmpty() {
		if (top.nextNode == null) {
			return true;
		}
		return false;
	}

	private class Node<E> {
		private Node<E> nextNode;
		private E data;

		Node(E data) {
			this.data = data;
			nextNode = null;
		}
	}
}