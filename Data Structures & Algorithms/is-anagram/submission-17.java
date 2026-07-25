class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int length = s.length();

        Map<Character, Integer> sM = new HashMap<>();
        Map<Character, Integer> tM = new HashMap<>();
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        
        for (int i = 0 ; i < length ; i++) {
            sM.put(sC[i], sM.getOrDefault(sC[i], 0) + 1);
            tM.put(tC[i], tM.getOrDefault(tC[i], 0) + 1);
        }
        return sM.equals(tM);
    }
}
