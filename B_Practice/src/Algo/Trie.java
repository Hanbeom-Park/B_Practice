import java.util.Scanner;

public class Trie {
    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String str){
        if(search(str)) {
            plusCount(str);
            return;
        }
        Node current = root;
        for(char ch: str.toCharArray()){
            Node child = current.subNode(ch);
            if(child!=null){
                current = child;
            }
            else{
                current.child[ch-'a'] = new Node(ch);
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.word=true;
        current.inputCount++;
        current.str=str;
    }



    public void plusCount(String str){
        Node current = root;
        for(char ch:str.toCharArray()){
            current = current.subNode(ch);

        }
        if(current.word) current.inputCount++;

    }

    public boolean search(String str){
        Node current = root;
        for(char ch: str.toCharArray()){
            if(current.subNode(ch)==null) return false;
            else{
                current = current.subNode(ch);
            }
        }
        if(current.word) return true;
        return false;
    }

    public void printword(){
        Node current = root;
        for(int i=0; i<26;i++){
            if(current.child[i]!=null){
                print(current.child[i]);
            }
        }
    }
    public void print(Node temp){
        if(temp.word){
            System.out.println(temp.str+" °Ë»öÈ½¼ö: "+temp.inputCount);
        }
        for(int i=0; i<26;i++){
            if(temp.child[i]!=null){
                print(temp.child[i]);
            }
        }
    }

    private class Node{
        Node child[];
        boolean word;
        int count;
        char nodeChar;
        int inputCount;
        String str;

        public Node(){
            this.count=0;
            this.child = new Node[26];
            this.word=false;
            this.nodeChar='\0';
            this.inputCount=0;
        }

        public Node(char c){
            this.count=0;
            this.nodeChar=c;
            this.word=false;
            this.child = new Node[26];
            this.inputCount=0;
        }
        public boolean isWord(){
            return word;
        }

        public Node subNode(char nextChar){
            if(child[nextChar-'a']!=null){
                return child[nextChar-'a'];
            }
            else return null;
        }
        @Override
        public String toString() {
            return this.nodeChar+"("+this.word+") ";
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++){
            trie.insert(sc.next());
        }
        trie.printword();

    }
}