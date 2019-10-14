package Jungol;
import java.util.Scanner;
 
public class Main1145 {
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        //흑-백
        int[][] map=new int[21][21];
        int[] dx= {-1,-1,-1,0,1,1,1,0};//0 4
        int[] dy= {-1,0,1,1,1,0,-1,-1};
        exit:for (int i = 1; i <= N; i++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
           
            if(x>19||y>19) {
                i--;
                continue;
            }
            int now=0;
            if(i%2==1) {//1이 흑 2가 백
                map[x][y]=1;
                now=1;
            }else {
                map[x][y]=2;
                now=2;
            }

            for (int j = 0; j <4; j++) {
                int count=0;
                int tx=x;
                int ty=y;
                
                while(now==map[tx][ty]) {
                    
                	tx=tx+dx[j];
                    ty=ty+dy[j];
                    count++;
                    //System.out.println(count);
                }
                tx=x+dx[j+4];
                ty=y+dy[j+4];
                while(now==map[tx][ty]) {
                    tx=tx+dx[j+4];
                    ty=ty+dy[j+4];
                    count++;
                }
                if(count==5) {
                    if(now==1) {
                        System.out.println("Black win");
                    }else {
                        System.out.println("White win");
                             
                    }
                    //break exit;
                    return;
                }
            }

        }
        System.out.println("Save");
    }
 
}
/*
25
9 1
9 2
5 8
5 9
7 9
3 11
6 12
7 12
9 8
9 7
9 9
8 8
9 10 
11 7
9 13
10 13
9 12
13 8
12 10
16 9
11 11
11 10
12 12
12 11
9 11
*/