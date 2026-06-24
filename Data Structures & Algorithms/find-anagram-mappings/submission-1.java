class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> valueToPos = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            valueToPos.put(nums2[i], i);
        }

        int[] mappings = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            mappings[i]  = valueToPos.get(nums1[i]);
        }

        return mappings;
    }
}