package D4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution7194{
	static ArrayList<Integer> check;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for (int i = 1; i <=TC; i++) {
			int s=sc.nextInt();
			int t=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			check=new ArrayList<>();
			Queue<Integer[]> queue=new LinkedList<>();
			queue.add(new Integer[] {s,0});
			int count=0;
			//s s*a s+b
		
			while(!queue.isEmpty()){
				Integer[] aa=queue.poll();
				if(aa[0]*b==t||aa[0]+a==t) {
					count=aa[1]+1;
					break;
				}
				//System.out.println(aa[0]+" "+aa[1]);
				check.add(aa[0]);
				if(aa[0]<=t/b&&!ccc(aa[0]*b)) {
					queue.add(new Integer[] {aa[0]*b,aa[1]+1});	
				}
				if(aa[0]<=t-a&&!ccc(aa[0]+a)) {
					queue.add(new Integer[] {aa[0]+a,aa[1]+1});
				}
				System.out.println(aa[0]+" "+aa[1]);
			}
			if(count==0) {
				System.out.println("#"+i+" -1");
			}else {
				System.out.println("#"+i+" "+(count));	
			}
			
		}
	}
	static boolean ccc(int n) {
		for (int i = 0; i < check.size(); i++) {
			if(check.get(i)==n) {
				return true;
			}
		}
		return false;
	}

}
/*
1
10 99 4 2

1
10 28 4 2
*/