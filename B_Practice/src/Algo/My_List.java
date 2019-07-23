package Algo;

public class My_List {
	//TEST CMD
//	int PUSH_BACK = 0;
//	int PUSH_FRONT = 1;
//	int INSERT = 2;
//	int POP_BACK = 3;
//	int POP_FRONT = 4;
//	int ERASE = 5;
//

	int NODE_SIZE = 30000;
	int HEAD = NODE_SIZE;
    int TAIL = NODE_SIZE + 1;
    int pos;
    Node[] node=new Node[NODE_SIZE + 2];
    My_List() {
        pos = 0;
        node[HEAD].next = TAIL;//HEAD노드 다음에는 TAIL노드
        node[TAIL].prev = HEAD;//TAIL노드 이전에는 HEAD노드
    }
    //리스트의 마지막에 data를 추가
    void push_back(int data) {
        int prev = node[TAIL].prev;
        int next = node[prev].next; // TAIL;
 
        node[pos].val = data;
 
        node[pos].prev = prev;
        node[prev].next = pos;
 
        node[pos].next = next;
        node[next].prev = pos;
        ++pos;
    }
    //리스트의 가장 앞에 data를 추가
    void push_front(int data) {
        int next = node[HEAD].next;
        int prev = node[next].prev; // HEAD
         
        node[pos].val = data;
 
        node[pos].prev = prev;
        node[prev].next = pos;
 
        node[pos].next = next;
        node[next].prev = pos;
        ++pos;
    }
    //리스트의 pos 위치에 data를 추가
    void insert(int p, int data) {
        int next = node[HEAD].next;
        for(int i = 0; i < p; ++i) {
            next = node[next].next;
        }
        int prev = node[next].prev;
     
        node[pos].val = data;
 
        node[pos].prev = prev;
        node[prev].next = pos;
 
        node[pos].next = next;
        node[next].prev = pos;
        ++pos;
    }
    //리스트 가장 뒤에 data를 삭제
    void pop_back() {
        int target = node[TAIL].prev;
 
        int prev = node[target].prev;
        int next = node[target].next;
 
        node[prev].next = next;
        node[next].prev = prev;
    }
    //리스트 가장 앞에 data를 삭제
    void pop_front() {
        int target = node[HEAD].next;
 
        int prev = node[target].prev;
        int next = node[target].next;
 
        node[prev].next = next;
        node[next].prev = prev;
    }
    //리스트의 pos위치에 data를 삭제
    void erase(int p) {
        int target = node[HEAD].next;
        for (int i = 0; i < p; ++i) {
            target = node[target].next;
        }
        int prev = node[target].prev;
        int next = node[target].next;
 
        node[prev].next = next;
        node[next].prev = prev;
    }
    class Node {
        int prev;
        int next;
        int val;
    };



	public static void main(String[] args) {
		My_List stl_list=new My_List();
		//TEST CMD


	}

}
