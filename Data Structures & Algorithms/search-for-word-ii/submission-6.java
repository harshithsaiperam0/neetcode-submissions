class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        // Step 1: Put all words into the trie
        for (String word : words) {
            insert(root, word);
        }

        int rows = board.length;
        int cols = board[0].length;

        // Step 2: Start DFS from every board cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        // Out of bounds
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }

        // Already visited in this path
        if (board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];
        int index = ch - 'a';

        // If this letter is not a valid next letter in trie, stop
        if (node.children[index] == null) {
            return;
        }

        TrieNode nextNode = node.children[index];

        // If we reached the end of a word, add it
        if (nextNode.word != null) {
            result.add(nextNode.word);

            // Prevent adding same word again
            nextNode.word = null;
        }

        // Mark current cell as visited
        board[r][c] = '#';

        // Explore four directions
        dfs(board, r + 1, c, nextNode, result);
        dfs(board, r - 1, c, nextNode, result);
        dfs(board, r, c + 1, nextNode, result);
        dfs(board, r, c - 1, nextNode, result);

        // Restore current cell
        board[r][c] = ch;
    }
}