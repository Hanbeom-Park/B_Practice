#include <iostream>
using namespace std;

class MyHeap {
private:
	int heap_size;
	int heap[100001];
public:
	void push(int data) {
		int target = heap_size + 1; //���ο� �� �������� �ϳ� �� ũ���Ѱ�
		while (target != 1 && heap[target / 2] < data) { //1�̾ƴϰ� �θ��尡 ���ε��°ź��� �۴�
			heap[target] = heap[target / 2]; //�θ� �������.
			target /= 2;
		}
		heap[target] = data; //while�� �ȿ��� target�� ��� �θ�� �ö�.
		++heap_size;
	};

	int pop() {
		if (isEmpty()) {
			return 0;
		}
		int parent = 1, child = 2, res = heap[parent];
		int temp = heap[heap_size]; //temp�� ������ ���� �ӽ÷� ����
		while (child < heap_size) { //child�� ã�Ƴ�����.
			if (child + 1 < heap_size && heap[child] < heap[child + 1]) { //child+1 = �����ʳ��
				++child; //if���� �ȵ����� child�� ���ʳ��, ������ child�� �����ʳ��
			}
			if (temp >= heap[child]) { //temp�� ũ��? �׷��� �ٷ� ����.
				break;//temp��ġ�� ���� ��������. �װ� �ø��⸸�ϸ�Ǵϱ�.
			}
			heap[parent] = heap[child]; //�װԾƴ϶�� (�����̳� ������ �ڽ��� ����ũ��)
			parent = child; //�θ���ġ�� �� �ڽ��� �ִ´�.
			child *= 2; //child�� �׷��Ƿ� *2�� ���༭ �ڽİ� �ٲ���
		}
		heap[parent] = temp; //�ٲ� parent ��ġ�� temp�� �ִ°���.
		--heap_size;
		return res;
	};

	bool isEmpty() {
		if (heap_size == 0)
			return true;
		else
			return false;
	};

	int size() {
		return heap_size;
	}
};

int main() {
	int x;
	MyHeap heap = MyHeap();
	scanf("%d", &x); //������ ���� 1 ~ 100,000
	for (int i = 0; i < x; i++) {
		int temp;
		scanf("%d", &temp);
		if (temp == 0) {
			printf("%d\n", heap.pop());
		}
		else {
			heap.push(temp);
		}
	}
	return 0;
}