#include <iostream>

using namespace std;

int heap_size;
int heap[100000];
void push(int val);
int pop();

int main() {
	int t;
	scanf("%d", &t);
	for (int i = 0; i < t; i++)
	{
		int tmp;
		scanf("%d",&tmp);

		if (tmp == 0){
			if (heap_size == 0) {
				printf("0\n");
			}
			else {
				printf("%d\n", pop());
			}
		}
		else {
			push(tmp);
		}
	}
	return 0;
}
void push(int val) {
	int target = heap_size + 1;
	while (target!=1&&heap[target/2]>val) {
		heap[target] = heap[target / 2];
		target = target / 2;
	}
	heap[target] = val;
	++heap_size;
}
int pop() {
	int parent = 1, child = 2;
	int result = heap[1];
	int temp = heap[heap_size];
	while (child<heap_size) {
		if (child + 1 < heap_size && heap[child] > heap[child + 1]) {
			++child;
		}
		if (temp<=heap[child]) {
			break;
		}
		heap[parent] = heap[child];
		parent = child;
		child *= 2;
	}
	heap[parent] = temp;
	--heap_size;
	return result;
}

