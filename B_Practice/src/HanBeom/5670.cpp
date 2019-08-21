#include <iostream>
using namespace std;


struct Trie {
	Trie* next[26];
	bool end;
	Trie() {
		for (size_t i = 0; i < 26; i++)
		{
			next[i] = 0;
		}
		end = false;
	}
	~Trie() {
		for (size_t i = 0; i < 26; i++)
		{
			delete next[i];
		}
	}
	void insert(char* key) {
		if (*key == '\0') {
			end = true;
			//return count;
		}
		else {
			int curr = *key - 'a';

			if (next[curr] == NULL) {
				next[curr] = new Trie();
			}
			next[curr]->insert(key + 1);
		}
	}
	int search(int count) {
		int check = 0;
		int sum = 0;
		
		for (size_t i = 0; i < 26; i++)
		{
			
			if (next[i] != NULL) {
				check++;
			}
		}

		if (count == 0) {
			for (size_t i = 0; i < 26; i++)
			{
				if (next[i] != NULL) {
					sum = sum + next[i]->search(count + 1);
				}
			}
		}
		else {
			if (check > 1) {
				for (size_t i = 0; i < 26; i++)
				{
					if (next[i] != NULL) {
						sum = sum + next[i]->search(count + 1);
						//check++;
					}
				}
			}
			else if (check == 1) {
				for (size_t i = 0; i < 26; i++)
				{
					if (!end&&next[i] != NULL) {
						sum = sum + next[i]->search(count);
					}
					else if(end&&next[i]!=NULL){
						sum = sum + next[i]->search(count+1);
					}
				}
			}
			else if (check == 0) {
				return sum+count;
			}
			if (end) {
				return sum+count;
			}
		}
		return sum;
		
	}
};

int main() {
	int N;
	while (scanf("%d", &N) != -1) {
		Trie* trie = new Trie();
		double sum = 0;
		for (size_t i = 0; i < N; i++)
		{
			char word[81];
			scanf("%s", &word);
			trie->insert(word);
		}
		sum=trie->search(0);
		
		delete trie;
		printf("%.2lf\n", sum /N);
	}
}
