package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main16235 {
	//맵은 r*c  
	//모든칸이 양분 5에서 시작
	//나무 M개 구매, 
	//봄에는 자신의 나이만큼 양분을 먹음. 나이가 1증가함. 여러 나무 존재시 어린 나무부터
	//양분 못먹으면 바로 사망
	//봄에 나무 죽으면 양분으로 변한다. 
	//죽은 나무 나이/2만큼의 양분 추가.
	//가을에 나이가 5의 배수인경우 번식한다. 8개의 칸에 나이가 1인 나무 생성.
	//겨울에는 양분이 추가된다. 
	//살아 있는 나무의 개수 출력
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dir_x= {0,-1,-1,-1,0,1,1,1};
		int[] dir_y= {-1,-1,0,1,1,1,0,-1};
		
		st=new StringTokenizer(br.readLine().trim());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[][] S2D2=new int[N+1][N+1];//겨울에 뿌리는 양분정보
		int[][] map=new int[N+1][N+1];//현재 땅의 양분 정보


		for (int i = 1; i <=N; i++) {
			st=new StringTokenizer(br.readLine().trim());
			Arrays.fill(map[i], 5);
			for (int j = 1; j <=N; j++) {
				S2D2[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		//번식은 가을에만 함.
		ArrayList<Tree> arr=new ArrayList<>();
		for (int i = 0; i <M; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			arr.add(new Tree(x,y,z));
		}

		//x->y->z순
		Collections.sort(arr,new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				return o2.z-o1.z;
			}
			
		});
		
		while(K>0) {
			//봄
			int[][] dead=new int[N+1][N+1];
			for (int i=arr.size()-1;i>=0;i--) {
				Tree tree=arr.get(i);
				if(map[tree.x][tree.y]>=tree.z) {
					map[tree.x][tree.y]=map[tree.x][tree.y]-tree.z;
					tree.z=tree.z+1;
				}else {
					dead[tree.x][tree.y]=dead[tree.x][tree.y]+tree.z/2;
					//System.out.println(tree.x+" "+tree.y+" "+tree.z+"사망함");
					arr.remove(i);
				}
			}
			//여름
			for (int i = 1; i <=N; i++) {
				for (int j = 1; j <=N; j++) {
					map[i][j]=map[i][j]+dead[i][j]+S2D2[i][j];
				}
			}
			
			//가을
			for (int i=0;i<arr.size();i++) {
				Tree tree=arr.get(i);
//				if(K>990) {
//					System.out.println(arr.get(i).x+" "+ arr.get(i).y+" "+arr.get(i).z+"AAAA");
//				}
				//
				if(tree.z%5==0) {
					for (int j = 0; j <8; j++) {
						if(tree.x+dir_x[j]<1||tree.x+dir_x[j]>N||tree.y+dir_y[j]<1||tree.y+dir_y[j]>N) {
							
						}else {
							arr.add(arr.size(),new Tree(tree.x+dir_x[j],tree.y+dir_y[j],1));
						}
					}
				}
				if(tree.z<5) {
					break;
				}
			}

//			if(K>990) {
//				for (int i = 0; i < arr.size(); i++) {
//					System.out.println(arr.get(i).x+" "+arr.get(i).y+" "+arr.get(i).z);					
//				}
//				System.out.println();
//			}
			//겨울
			
			K--;
		}
		System.out.println(arr.size());
		
	}
	static class Tree{
		int x;
		int y;
		int z;
		Tree(int x,int y,int z){
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
}

/*
10 1 1000
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
100 100 100 100 100 100 100 100 100 100
1 1 1

*/