#include <iostream>
using namespace std;
class MyMinHeap {
private:
	int heap_size=0;
	int heap[100001];
public:
	void push(int data) {
		int target = heap_size + 1;
		while (target != 1 && heap[target / 2] > data) {
			heap[target] = heap[target / 2];
			target /= 2;
		}
		heap[target] = data;
		heap_size++;
	};

	int pop() {
		if (isEmpty())
			return 0;
		int parent = 1, child = 2;
		int temp = heap[heap_size];
		int res = heap[parent];
		while (child < heap_size) {
			if (child + 1 < heap_size && heap[child] > heap[child + 1]) {
				child++;
			}
			if (temp <= heap[child]) {
				break;
			}
			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = temp;
		heap_size--;
		return res;
	};

	bool isEmpty() {
		if (heap_size == 0)
			return true;
		else
			return false;
	}
};

int main() {
	int x;
	scanf_s("%d", &x);
	MyMinHeap heap = MyMinHeap();
	for (int i = 0; i < x; i++) {
		int val;
		scanf_s("%d", &val);
		if (val == 0) {
			printf("%d\n", heap.pop());
		}
		else {
			heap.push(val);
		}
	}
	return 0;
}