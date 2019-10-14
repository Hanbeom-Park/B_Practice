import java.util.Arrays;
import java.util.Scanner;


public class Dijkstra {
	static int V,E;
	static int[][] map;
	static int[] distance;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		map=new int[V+1][V+1];
		distance=new int[V+1];
		visit=new boolean[V+1];
		for (int i = 0; i <E; i++) {
			int s=sc.nextInt();
			int e=sc.nextInt();
			int va=sc.nextInt();
			
			map[s][e]=va;
			map[e][s]=va;
		}
		dijkstra(2);
		System.out.println(Arrays.toString(distance));
	}
	static void dijkstra(int k) {
		for (int i = 1; i < distance.length; i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		distance[k]=0;
		visit[k]=true;
		for (int i = 1; i < distance.length; i++) {
			if(map[k][i]!=0) {
				distance[i]=map[k][i];
			}
		}
		System.out.println(Arrays.toString(distance));
		while(true) {
			if(Allvisited()) {
				break;
			}
			int min=Integer.MAX_VALUE;
			int minNode=-1;
			for (int i = 1; i < distance.length; i++) {
				if(!visit[i]&&distance[i]<min) {
					min=distance[i];
					minNode=i;
				}
			}
			visit[minNode]=true;
			for (int i = 1; i < distance.length; i++) {
				if(!visit[i]&&map[minNode][i]!=0&&distance[i]>distance[minNode]+map[minNode][i]) {
					distance[i]=distance[minNode]+map[minNode][i];
				}
			}
			
		}
		
		
	}
	static boolean Allvisited() {
		for (int i = 1; i <=V; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		return true;
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