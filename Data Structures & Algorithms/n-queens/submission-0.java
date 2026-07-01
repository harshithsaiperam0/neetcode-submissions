class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] box = new char[n][n];

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                box[i][j] = '.';
            }
        }

        backtrack(0, box, res);
        return res;
    }

    private boolean isSafe(int r, int c, char[][] box) {
        for (int i = r - 1 ; i >= 0 ; i--) {
            if (box[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1 ; i >= 0 && j >= 0 ; i-- , j--) {
            if (box[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < box.length; i--, j++) {
            if (box[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<List<String>> backtrack(int r, char[][] box, List<List<String>> res) {
        if (r == box.length) {
            List<String> re = new ArrayList<>();
            for (char[] b : box) {
                re.add(new String(b));
            }
            res.add(re);
            return res;
        }
        for (int c = 0 ; c < box.length ; c++) {
            if (isSafe(r,c,box)) {
                box[r][c] = 'Q';
                backtrack(r + 1, box, res);
                box[r][c] = '.';
            }
        }
    return res;
    }

}