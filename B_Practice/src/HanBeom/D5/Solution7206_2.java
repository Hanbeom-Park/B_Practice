package D5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution7206_2 {
	//숫자를 전부 잘라본다.
	//곱해서 합친 숫자를 다시 잘라서 집어넣는다.
	static int max;
	static int[] dp=new int[100000];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		Arrays.fill(dp, -1);
		for (int i = 0; i <10; i++) {
			dp[i]=0;
		}
		for (int i = 10; i <100000; i++) {
			dfs(""+i,0,new boolean[(""+i).length()],(""+i).length(),0);
			dp[i]=max;
			max=0;
		}
		for (int i = 1; i <100; i++) {
			//System.out.print(dp[i]+" ");
		}
		for (int i = 1; i <=T; i++) {
			int n=sc.nextInt();
			System.out.println("#"+i+" "+dp[n]);
			//System.out.println("#"+i+" "+max);
		}
	}
	static void dfs(String n,int index,boolean[] check,int len,int count) {
		if(index==len) {
			ArrayList<Integer> num=new ArrayList<>();
			int tmp=0;
			//System.out.println(Arrays.toString(check));
			if(check[len-1]==false) {
				return;
			}
			for (int i = 0; i < check.length; i++) {
				if(check[i]) {
					num.add(Integer.parseInt(n.substring(tmp, i+1)));
					//System.out.print(Integer.parseInt(n.substring(tmp, i+1))+"-");
					tmp=i+1;
				}					
			}
			//System.out.println();
			int tot=1;
			if(num.size()==1) {
				return;
			}
			for (int i = 0; i < num.size(); i++) {
				tot=tot*num.get(i);
			}
			//System.out.println(tot);
			if(dp[tot]!=0) {
				count=count+dp[tot];				
			}else{
				dfs(""+tot,0,new boolean[(""+tot).length()],(""+tot).length(),count+1);
			}
			if(count+1>max) {
				max=count+1;
			}
			return;
		}
		check[index]=true;
		dfs(n,index+1,check,len,count);
		check[index]=false;	
		dfs(n,index+1,check,len,count);
		
		
	}
}
/*
1
123

*/