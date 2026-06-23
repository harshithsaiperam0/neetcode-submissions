class Solution {
    public boolean isPalindrome(String s) {
        char[] cha = s.toCharArray();

        int l = 0;
        int r = cha.length - 1;

        while (l < r) {

            if (!isAlphaNum(cha[l])) {
                l++;
                continue;
            }

            if (!isAlphaNum(cha[r])) {
                r--;
                continue;
            }

            if (Character.toLowerCase(cha[l]) != Character.toLowerCase(cha[r])) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    private boolean isAlphaNum(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}