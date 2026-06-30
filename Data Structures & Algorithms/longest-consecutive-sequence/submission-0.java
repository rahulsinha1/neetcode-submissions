class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        int finalLength = 0 ;
        for (int i=0;i<nums.length;i++){
            int currentLength = 1;
            if (set.contains(nums[i]-1)){
                continue;
            }
            int currentNumber = nums[i];
            while (set.contains (currentNumber+1)){
                currentNumber++;
                currentLength++;
            }
            finalLength = Math.max(currentLength, finalLength);
        }
        return finalLength;
    }
}
