
public class My_Hash {
	static String input[][];
	static int HASH_SIZE;
	static int PN = 23;
	static int name_size;
	static String[] name;
	static int table[][];

	public My_Hash(int size) {
		input = new String[size][100];
		HASH_SIZE = size / 3;
		name = new String[size];
		table = new int[HASH_SIZE][30];
	}

	int unsigned(int n) {
		if (n < 0)
			return n * -1;
		else
			return n;
	}

	int get_key(String _data) {
		int key = 0, p = 1;
		for (int i = 0; i < _data.length(); i++) {
			key += unsigned(_data.charAt(i) * p);
			p *= PN;
		}
		return unsigned(key % HASH_SIZE);
	}

	boolean my_strcmp(String a, String b) {
		int idx = 0;
		boolean ok = true;
		while (idx < b.length()) {
			if (a.charAt(idx) != b.charAt(idx)) {
				ok = false;
				break;
			}
			idx++;
		}
		return ok;
	}

	int contain(String _data) {
		int key = get_key(_data);
		int h_size = table[key][0];
		for (int i = 1; i <= h_size; i++) {
			int n_pos = table[key][i];
			if (my_strcmp(name[n_pos], _data) == true) {
				return n_pos;
			}
		}
		return -1;
	}

	void add(String _name) {
		name[name_size] = _name; // 배열에 해당 문자열 저장.
		int key = get_key(_name); // 키 값 변환
		int h_size = table[key][0]; // 키 위치 배열의 size 반환
		table[key][++h_size] = name_size; // h_size는 해당 key 배열의 크기, name_size는 index번호 및 문자열배열의 크기임.
		table[key][0] += 1;
		name_size++;
	}

	boolean remove(String _name) {
		int key = get_key(_name);
		int h_size = table[key][0];
		for (int i = 1; i <= h_size; i++) {
			int n_pos = table[key][i];
			if (my_strcmp(name[n_pos], _name) == true) {
				for (int j = i; j <= h_size; j++) {
					table[key][j] = table[key][j + 1];
				}
				//h_size--;
				table[key][0]--;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		My_Hash h = new My_Hash(1000);
		h.add("apple");
		h.add("banana");
		System.out.println("apple key: " + h.get_key("apple"));
		System.out.println("banana key: " + h.get_key("banana"));
		System.out.println("REMOVE banna: " + h.remove("banna"));
		System.out.println("REMOVE banna: " + h.remove("banana"));
		System.out.println("CONTAIN app: " + h.contain("app"));
		System.out.println("CONTAIN apple: " + h.contain("apple"));
	}
}
