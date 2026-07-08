class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sM = new HashMap<>();
        Map<Character, Integer> tM = new HashMap<>();

        for(char ch : s.toCharArray()) {
            sM.put(ch, sM.getOrDefault(ch, 0) + 1);
        }
        for(char ch : t.toCharArray()) {
            tM.put(ch, tM.getOrDefault(ch, 0) + 1);
        }

    return sM.equals(tM);
    }
}
