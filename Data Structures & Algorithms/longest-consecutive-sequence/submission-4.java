class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            int length = 1;
            while (set.contains(num + length)) length++;
            res = Integer.max(res, length);
        }
        return res;
    }
}
