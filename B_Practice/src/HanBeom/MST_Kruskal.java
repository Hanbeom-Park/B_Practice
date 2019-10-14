import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MST_Kruskal {
	static PriorityQueue<Edge> pq;
	static ArrayList<Edge> mst;
	static int[] parent;
	static int V,E;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		parent=new int[V+1];
		mst=new ArrayList<>();
		pq=new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.value-o2.value;
			}
		});
		for (int i = 0; i < E; i++) {
			pq.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		kruskal();
		for (Edge edge:mst) {
			System.out.println(edge.toString());
		}
	}
	static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		parent[n]=find(parent[n]);
		return parent[n];
	}
	static void union(int n1,int n2) {
		int p1=find(parent[n1]);
		int p2=find(parent[n2]);
		parent[p1]=p2;
	}
	static void kruskal() {
		for (int i = 1; i < parent.length; i++) {
			parent[i]=i;
		}
		for (int i = 0; i < E; i++) {
			Edge edge=pq.poll();
			if(find(edge.start)==find(edge.end)) {
				continue;
			}
			union(edge.start,edge.end);
			mst.add(edge);
			
		}
		
	}
	static class Edge{
		int start;
		int end;
		int value;
		Edge(int s,int e ,int v){
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