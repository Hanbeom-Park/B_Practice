public class MyQueue<T> {
	private Node head, tail;

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return head == null;
	}

	// �������� �߰��� tail �� �Ѵ� (���� ������� ���� ����� ��)
	public void add(T item) {
		Node oldlast = tail; // ������ tail �� ��� �����صΰ�
		tail = new Node(); // ���ο� tail �� �����Ѵ�
		tail.item = item;
		tail.next = null;
		if (isEmpty())
			head = tail; // queue �� ��������� head = tail �� head �� tail �� ���� node �� ����Ű�� �Ѵ�
		else
			oldlast.next = tail; // queue �� ������� ������ ���� tail �� next = ���ο� tail �� ���ָ� �ȴ�
	}

	// ������ ������ �۾��� head �� �Ѵ� (���� ���Դ� �����ͺ��� ������)
	public T poll() {
		// ����ִ� ���
		if (isEmpty()) {
			tail = head;
			System.out.println("Queue is empty");
			return null;
		}
		// ������� ������
		else {
			T item = head.item; // head �� �����͸� ����
			head = head.next; // ���� head ���� node (Ȥ�� null) �� head �� �������ش�
			return item;
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}