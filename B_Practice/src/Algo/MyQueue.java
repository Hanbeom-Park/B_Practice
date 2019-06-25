public class MyQueue<T> {
	private Node head, tail;

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return head == null;
	}

	// 데이터의 추가는 tail 에 한다 (들어온 순서대로 줄을 세우는 셈)
	public void add(T item) {
		Node oldlast = tail; // 기존의 tail 을 잠시 보관해두고
		tail = new Node(); // 새로운 tail 을 생성한다
		tail.item = item;
		tail.next = null;
		if (isEmpty())
			head = tail; // queue 가 비어있으면 head = tail 로 head 와 tail 이 같은 node 를 가리키게 한다
		else
			oldlast.next = tail; // queue 가 비어있지 않으면 기존 tail 의 next = 새로운 tail 로 해주면 된다
	}

	// 데이터 꺼내는 작업은 head 로 한다 (먼저 들어왔던 데이터부터 꺼낸다)
	public T poll() {
		// 비어있는 경우
		if (isEmpty()) {
			tail = head;
			System.out.println("Queue is empty");
			return null;
		}
		// 비어있지 않으면
		else {
			T item = head.item; // head 의 데이터를 저장
			head = head.next; // 기존 head 다음 node (혹은 null) 를 head 로 설정해준다
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