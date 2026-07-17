class WordDictionary {
    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    // Unchanged from the plain trie: walk down, create missing nodes.
    public void addWord(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (current.children[i] == null) {
                current.children[i] = new Node();
            }
            current = current.children[i];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    // "Starting at `node`, can word[index..] be matched?"
    private boolean dfs(Node node, int index, String word) {
        // Base case: word exhausted -> only a match if a word actually ends here.
        if (index == word.length()) return node.endOfWord;

        char c = word.charAt(index);

        if (c == '.') {
            // Try every existing child; ANY success is enough.
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null
                        && dfs(node.children[i], index + 1, word)) {
                    return true;                    // capture the answer, bail early
                }
            }
            return false;                           // all 26 branches dead
        }

        // Normal letter: exactly one child to follow.
        int i = c - 'a';
        if (node.children[i] == null) return false; // path dies
        return dfs(node.children[i], index + 1, word);
    }
}

class Node {
    Node[] children = new Node[26];
    boolean endOfWord;
}