#include <iostream>
using namespace std;

class MyHeap {
private:
	int heap_size;
	int heap[100001];
public:
	void push(int data) {
		int target = heap_size + 1; //새로운 것 들어왔으니 하나 더 크게한거
		while (target != 1 && heap[target / 2] < data) { //1이아니고 부모노드가 새로들어온거보다 작다
			heap[target] = heap[target / 2]; //부모를 끌어내린다.
			target /= 2;
		}
		heap[target] = data; //while문 안에서 target은 계속 부모로 올라감.
		++heap_size;
	};

	int pop() {
		if (isEmpty()) {
			return 0;
		}
		int parent = 1, child = 2, res = heap[parent];
		int temp = heap[heap_size]; //temp에 마지막 값을 임시로 저장
		while (child < heap_size) { //child를 찾아나간다.
			if (child + 1 < heap_size && heap[child] < heap[child + 1]) { //child+1 = 오른쪽노드
				++child; //if문에 안들어오면 child는 왼쪽노드, 들어오면 child는 오른쪽노드
			}
			if (temp >= heap[child]) { //temp가 크다? 그러면 바로 종료.
				break;//temp위치는 제일 마지막임. 그걸 올리기만하면되니까.
			}
			heap[parent] = heap[child]; //그게아니라면 (왼쪽이나 오른쪽 자식이 제일크면)
			parent = child; //부모위치에 그 자식을 넣는다.
			child *= 2; //child는 그러므로 *2를 해줘서 자식값 바꿔줌
		}
		heap[parent] = temp; //바뀐 parent 위치에 temp를 넣는거임.
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
	scanf("%d", &x); //연산의 갯수 1 ~ 100,000
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