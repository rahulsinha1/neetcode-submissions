class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }

        int left  = 0;
        int result = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right ++){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left ++;
            }

            set.add(s.charAt(right));
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}
