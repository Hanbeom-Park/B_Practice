public class Powerset {
	public static void main(String[] args) {
		char[] arr = {'a','b','c'};
		boolean[] use = new boolean[arr.length];
		powerSet(arr, use, 0);
	}
	static void powerSet(char[] arr, boolean[] use, int d) {
		if(d== arr.length) {
			System.out.print("{");
			for (int i = 0; i < arr.length; i++) {
				if(use[i]) {
					System.out.print(arr[i]+ " ");
				}
			}
			System.out.println("}");
			return;
		}
		use[d] = true;
		powerSet(arr, use, d+1);
		use[d] = false;
		powerSet(arr, use, d+1);
	}
}