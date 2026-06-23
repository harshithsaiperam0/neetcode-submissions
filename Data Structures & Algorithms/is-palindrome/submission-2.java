class Solution {
    public boolean isPalindrome(String s) {
        char[] cha = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {

            if (!isAlphaNum(s.charAt(l))) {
                l++;
                continue;
            }

            if (!isAlphaNum(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
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