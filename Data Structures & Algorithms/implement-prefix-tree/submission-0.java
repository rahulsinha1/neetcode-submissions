class PrefixTree {
    Node root;
    public PrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node currentNode = root;
        for(char c: word.toCharArray()){
            int i = c-'a';
            if(currentNode.children[i] == null){
                currentNode.children[i] = new Node();
            }
            currentNode = currentNode.children[i];
        }
        currentNode.endOfWord = true;
    }

    public boolean search(String word) {
        Node currentNode = root;
        for(char c: word.toCharArray()){
            int i = c-'a';

            if(currentNode.children[i] == null){
                return false;
            }
            currentNode = currentNode.children[i];
        }
        if(currentNode.endOfWord){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node currentNode = root;

        for(char c: prefix.toCharArray()){
            int i = c-'a';
            if(currentNode.children[i] == null){
                return false;
            }
            currentNode = currentNode.children[i];
        }
        return true;
    }
}

class Node{
    boolean endOfWord;
    Node [] children;

    public Node(){
        this.children = new Node[26];
        this.endOfWord = false;
    }
    public Node (boolean endOfWord){
        this.children = new Node [26];
        this.endOfWord = endOfWord;
    }
}
