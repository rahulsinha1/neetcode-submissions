class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }
        int result = 1;
        for (int i = 0; i< nums.length; i++){
            int currentLength = 1;
            if(set.contains(nums[i]-1)){
                continue;
            }

            int currentNumber = nums[i];

            while(set.contains(currentNumber+1)){
                currentNumber = currentNumber + 1;
                currentLength ++;
            }
            result = Math.max(currentLength, result);
        }
        return result;
    }
}
