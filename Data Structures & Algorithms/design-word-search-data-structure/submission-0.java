class WordDictionary {
    class Trie {
        Trie[] children = new Trie[26];
        boolean isWord = false;
    }
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie ptr = root;
        for (char ch: word.toCharArray()) {
            if (ptr.children[ch-'a'] == null)
                ptr.children[ch-'a'] = new Trie();
            ptr = ptr.children[ch-'a'];
        }
        ptr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(Trie root, String word, int idx) {
        Trie cur = root;

        for (int i=idx; i<word.length(); i++) {
            char c = word.charAt(i);
            if (c =='.') {
                for (Trie child: cur.children) {
                    if (child != null && dfs(child, word, i+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c-'a'] == null)
                    return false;
                cur = cur.children[c-'a'];
            }
        }

        return cur.isWord;
    }
}
