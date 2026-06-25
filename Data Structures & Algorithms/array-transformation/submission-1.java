class Solution {
    public List<Integer> transformArray(int[] arr) {
        boolean changed = true;

        while (changed) {
            changed = false;

            int[] next = arr.clone();

            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    next[i] = arr[i] + 1;
                    changed = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    next[i] = arr[i] - 1;
                    changed = true;
                }
            }

            arr = next;
        }

        List<Integer> result = new ArrayList<>();

        for (int num : arr) {
            result.add(num);
        }

        return result;
    }
}