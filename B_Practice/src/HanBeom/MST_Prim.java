

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MST_Prim {
	static int V,E;
	static ArrayList<Edge> mst;
	static PriorityQueue<Edge> pq;
	static boolean[] visit;
	static ArrayList<Edge>[] graph;
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		visit=new boolean[V+1];
		mst=new ArrayList<>();
		pq=new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.value-o2.value;
			}
		});
		graph=new ArrayList[V+1];
		for (int i = 1; i <=V; i++) {
			graph[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int s=sc.nextInt();
			int e=sc.nextInt();
			int va=sc.nextInt();
			graph[s].add(new Edge(s,e,va));
			graph[e].add(new Edge(e,s,va));
			
		}
		prim();
		for (Edge edge:mst) {
			System.out.println(edge.toString());
		}
	}
	static void prim() {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(1);
		while(!queue.isEmpty()) {
			int nowV=queue.poll();
			visit[nowV]=true;
			for (Edge edge:graph[nowV]) {
				if(!visit[edge.end]) {
					pq.add(edge);
				}
			}
			
			
			while(!pq.isEmpty()) {
				Edge edge=pq.poll();
				if(!visit[edge.end]) {
					queue.add(edge.end);
					mst.add(edge);
					break;
				}
			}
		}
		
	}
	static class Edge{
		int start;
		int end;
		int value;
		Edge(int s,int e,int v) {
			start=s;
			end=e;
			value=v;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
		
	}
}
/*
7
11
1 2 2
2 3 5
1 3 20
1 4 10
4 5 1
5 6 23
3 6 3
3 5 6
7 6 9
7 3 2
2 7 7

*/