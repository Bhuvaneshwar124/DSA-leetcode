class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> st = new HashSet<>();

        for (int x : nums)
            st.add(x);

        for (int i = 1; ; ++i) {
            int x = k * i;

            if (!st.contains(x))
                return x;
        }
    }
}