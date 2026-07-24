class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        addToTrie(root, word, 0);
    }

    private void addToTrie(TrieNode node, String word, int index){
        if(index == word.length()){
            node.endOfWord = true;
            return;
        }

        int i = word.charAt(index) -'a';
        if(node.children[i] == null){
            node.children[i] = new TrieNode();
        }
        index ++;
        addToTrie(node.children[i], word, index);
    }

    public boolean search(String word) {
        return searchInTrie(root, 0, word);
    }

    private boolean searchInTrie(TrieNode node , int index, String word){
        if(index == word.length()){
            return node.endOfWord;
        }
        if(word.charAt(index) == '.'){
            for(int i =0; i<26;i++){
                if(node.children[i] == null) continue;
                if(searchInTrie(node.children[i], index+1, word))
                    return true;
            }
            return false;
        }

        int i = word.charAt(index) - 'a';
        if(node.children[i] == null){
            return false;
        }
        index ++;
        return searchInTrie(node.children[i], index, word);
    }

}


class TrieNode{
    boolean endOfWord = false;
    TrieNode [] children = new TrieNode [26];

    public TrieNode(){}
}
