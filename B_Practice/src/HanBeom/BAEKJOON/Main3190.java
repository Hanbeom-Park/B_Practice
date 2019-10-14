package BAEKJOON;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main3190{

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt()+1;
		int K=sc.nextInt();
		int[][] map=new int[N][N];
		int[] dx= {0,1,0,-1};//우 하 좌 상
		int[] dy= {1,0,-1,0};//우 하 좌 상
		
		for (int i = 0; i <K; i++) {
			map[sc.nextInt()][sc.nextInt()]=1;
		}

		int L=sc.nextInt();
		Queue<int[]> queue=new LinkedList<>();
		Stack<int[]> stack=new Stack<>();
		
		queue.add(new int[] {1,1});
		stack.add(new int[] {1,1,0});
		int count=0;
		int aa=0;
		exit:for (int i = 0; i <L; i++) {
			int X=sc.nextInt();
			//L이면 왼쪽  D면 오른쪽 90도 
			//
			
			for (int j = aa; j < X; j++) {
				count++;

				int[] now=stack.pop();
				map[now[0]][now[1]]=2;
				if(now[0]+dx[now[2]]<1||now[1]+dy[now[2]]<1||now[0]+dx[now[2]]>=N||now[1]+dy[now[2]]>=N) {
					//벽박고 사망
					break exit;
				}else {

					if(map[now[0]+dx[now[2]]][now[1]+dy[now[2]]]==2) {
						//지몸 박아서 사망
						break exit;
					}
					if(map[now[0]+dx[now[2]]][now[1]+dy[now[2]]]==1) {
						//사과 먹음
					}else {
						//사과 못먹음
						int[] tmp=queue.poll();
						map[tmp[0]][tmp[1]]=0;
					}
					queue.add(new int[] {now[0]+dx[now[2]],now[1]+dy[now[2]]});

					stack.push(new int[] {now[0]+dx[now[2]],now[1]+dy[now[2]],now[2]});
		
				}
			}
			int[] tmp=stack.pop();
			String dir=sc.next();
			if(dir.equals("D")) {
				stack.push(new int[] {tmp[0],tmp[1],(tmp[2]+1)%4});
			}else {
				stack.push(new int[] {tmp[0],tmp[1],(tmp[2]+3)%4});
			}

			aa=X;
		}
//		for (int m = 1; m <N; m++) {
//			for (int m2 = 1; m2 < N; m2++) {
//				System.out.print(map[m][m2]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		if(!stack.isEmpty()) {
		int[] now=stack.pop();

		while(true) {
			count++;
			
			if(now[0]+dx[now[2]]<1||now[1]+dy[now[2]]<1||now[0]+dx[now[2]]>=N||now[1]+dy[now[2]]>=N) {
				
				break;
			}
			if(map[now[0]+dx[now[2]]][now[1]+dy[now[2]]]==2) {
				//지몸 박아서 사망
				break;
			}
			if(map[now[0]+dx[now[2]]][now[1]+dy[now[2]]]==1) {
				//사과 먹음
			}else {
				//사과 못먹음
				int[] tmp=queue.poll();
				map[tmp[0]][tmp[1]]=0;
			}
			queue.add(new int[] {now[0]+dx[now[2]],now[1]+dy[now[2]]});

			now[0]=now[0]+dx[now[2]];
			now[1]=now[1]+dy[now[2]];

		}
		}
		System.out.println(count);
	}

}