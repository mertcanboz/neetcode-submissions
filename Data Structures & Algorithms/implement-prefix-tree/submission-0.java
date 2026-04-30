class PrefixTree {
    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;
    }

    private Trie root;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie ptr = root;
        for (char c: word.toCharArray()) {
            if (ptr.children[c-'a'] == null) {
                ptr.children[c-'a'] = new Trie();
            }
            ptr = ptr.children[c-'a'];
        }
        ptr.isEnd = true;
    }

    public boolean search(String word) {
        Trie ptr = root;
        for (char c: word.toCharArray()) {
            if (ptr.children[c-'a'] == null) {
                return false;
            }
            ptr = ptr.children[c-'a'];
        }
        return ptr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie ptr = root;
        for (char c: prefix.toCharArray()) {
            if (ptr.children[c-'a'] == null) {
                return false;
            }
            ptr = ptr.children[c-'a'];
        }
        return true;
    }
}
