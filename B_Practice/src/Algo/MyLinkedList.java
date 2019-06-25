public class MyLinkedList<T> {

	private Node header;
	private int size;

	public MyLinkedList() {

		header = new Node(null);
		size = 0;
	}

	// �ܼ� ���� ����Ʈ ���
	private class Node {

		private T data;
		private Node nextNode;

		Node(T data) {

			this.data = data;
			this.nextNode = null;
		}

	}

	// index ��ġ�� ��� �����͸� ��ȯ�Ѵ�.
	public T get(int index) {
		return getNode(index).data;
	}

	// index ��ġ�� ��带 ��ȯ�Ѵ�.
	private Node getNode(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		}

		Node node = header.nextNode;
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}

		return node;
	}

	// ù��° ����� �����͸� ��ȯ�Ѵ�.
	public T getFirst() {
		return get(0);
	}

	// �ش� �������� ��� ��ġ index�� ��ȯ�Ѵ�.
	public int getNodeIndex(T obj) {

		if (size <= 0) {
			return -1;
		}

		int index = 0;
		Node node = header.nextNode;
		T nodeData = node.data;

		// header���� ���� ���������� nodeData�� ���� ���Ѵ�.
		while (!obj.equals(nodeData)) {
			node = node.nextNode;

			if (node == null) {
				return -1;
			}

			nodeData = node.data;
			index++;
		}

		return index;
	}

	// data�� ����Ʈ�� ù��°�� �����Ѵ�.
	public void addFirst(T data) {

		Node newNode = new Node(data);
		newNode.nextNode = header.nextNode;
		header.nextNode = newNode;
		size++;

	}

	// index ��ġ�� data�� �����Ѵ�.
	public void add(int index, T data) {

		if (index == 0) {
			addFirst(data);
			return;
		}

		Node previous = getNode(index - 1);
		Node next = previous.nextNode;

		Node newNode = new Node(data);
		previous.nextNode = newNode;
		newNode.nextNode = next;
		size++;
	}

	// ����Ʈ�� �������� data �� �����Ѵ�.
	public void addLast(T data) {
		add(size, data);
	}

	// ����Ʈ�� �������� data�� �����Ѵ�.
	public void add(T data) {
		addLast(data);
	}

	// ù��° ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
	public T removeFirst() {

		Node firstNode = getNode(0);
		header.nextNode = firstNode.nextNode;
		size--;
		return firstNode.data;

	}

	// index ��ġ�� ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
	public T remove(int index) {

		if (index < 0 || index >= size) {

			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);

		} else if (index == 0) {

			return removeFirst();

		}

		Node previous = getNode(index - 1);
		Node removeNode = previous.nextNode;
		Node next = removeNode.nextNode;
		previous.nextNode = next;
		size--;

		return removeNode.data;
	}

	// ����Ʈ���� data�� ���� ��带 �����ϰ� ���ſ��θ� ��ȯ�Ѵ�.
	public boolean remove(T data) {

		int nodeIndex = getNodeIndex(data);

		if (nodeIndex == -1) {
			return false;
		} else {
			remove(nodeIndex);
			return true;
		}
	}

	// ����Ʈ�� ������ ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
	public T removeLast() {
		return remove(size - 1);
	}

	// ����Ʈ�� ũ�⸦ ��ȯ�Ѵ�.
	public int size() {
		return size;
	}

//	// ����Ʈ�� ������ String���� ��ȯ
//	public String toString() {
//
//		StringBuffer result = new StringBuffer("[");
//		Node node = header.nextNode;
//
//		if (node != null) {
//			result.append(node.data);
//			node = node.nextNode;
//
//			while (node != null) {
//				result.append(", ");
//				result.append(node.data);
//				node = node.nextNode;
//			}
//		}
//
//		result.append("]");
//		return result.toString();
//	}

	public static void main(String[] args) {

		MyLinkedList<Integer> list = new MyLinkedList();

		list.add(100);
		list.add(200);
		list.add(400);
		list.add(500);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");
		list.add(2, 300);
		list.addFirst(50);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");
		System.out.println("get(4): " + list.get(4));

		System.out.println("remove(2): " + list.remove(2));

		list.removeFirst();
		list.removeLast();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");

		System.out.println("ũ�� " + list.size());

	}
}