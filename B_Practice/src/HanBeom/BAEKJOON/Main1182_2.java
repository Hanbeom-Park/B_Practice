package BAEKJOON;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1182_2 {
	static int[] map;
	static int S;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//합쳐서 S가 되는 경우 구하기
		int N=sc.nextInt();
		
		S=sc.nextInt();
		map=new int[N];
		int tot=0;
		ArrayList<Integer> arr=new ArrayList<>();
		
		for (int i = 0; i < map.length; i++) {
			map[i]=sc.nextInt();
		}
		arr.add(0);
		for (int i = 0; i < map.length; i++) {
			int aa=arr.size();
			for (int j = 0; j <aa; j++) {
				arr.add(arr.get(j)+map[i]);
			}
		}
		int count=0;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i)==S) {
				count++;
			}
		}
		if(S==0) {
			count--;
		}
		System.out.println(count);
	}
}
