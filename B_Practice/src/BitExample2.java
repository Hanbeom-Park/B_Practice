

public class BitExample2 {

	public static void main(String[] args) {
		int x=0x01020304;
		int y=0x100;
		char a=0x10;
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(Integer.toBinaryString(x));
//		System.out.printf("%x\n",x);
//		System.out.printf("%o\n",x);
//		System.out.printf("%x",255);
//		
		System.out.println("10진수 0x10 = "+(int)a);
		System.out.print("2진수 0x10 = ");
		bit_print(a&0xff);
		System.out.println();
		
		System.out.printf("0%x를 2진수를 변환한 결과\n",x);
		for (int i = 3; i >=0; i--) {
			bit_print((x>>i*8)&0xff);
		}
	}
	static void bit_print(int i) {
		for (int j = 7; j>=0; j--) {
			System.out.print((i&(1<<j))!=0?1:0);
		}
		System.out.print(" ");
	}

}
