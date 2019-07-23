package Algo;

public class Heap {
	static int heap_size;
	static int[] heap=new int[10000];
	 
	static void push(int data) {
	    int target = heap_size + 1;
	    while (target != 1 && heap[target / 2] < data) {
	        heap[target] = heap[target / 2];
	        target /= 2;
	    }
	    heap[target] = data;
	    ++heap_size;
	}
	 
	static void pop() {
	    int parent = 1, child = 2;
	    int temp = heap[heap_size];
	    while (child < heap_size) {
	        if (child + 1 < heap_size && heap[child] < heap[child + 1]) {
	            ++child;
	        }
	        if (temp >= heap[child]) {
	            break;
	        }
	        heap[parent] = heap[child];
	        parent = child;
	        child *= 2;
	    }
	    heap[parent] = temp;
	    --heap_size;
	}


	public static void main(String[] args) {
		 int[] a=new int[10000];
				 int[] b=new int[10000];
		    for (int i = 0; i < 9999; ++i) {
		        a[i] = (int)(Math.random() * 10000);
		        b[i] = a[i];
		    }
		 
		    for (int i = 0; i < 9999; ++i) {
		        push(b[i]);
		    }
		 
		    for (int i = 0; i < 9999; ++i) {
		        if (a[i] != heap[1]) {
		            System.out.println("not heap!!!\n");
		        }
		        pop();
		    }
	}

}
