class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            int target = - (nums[i]);

            while(start<end){
                if(nums[start]+ nums[end] == target){
                    result.add(new ArrayList<>(List.of(nums[i], nums[start], nums[end])));
                    start ++;
                    end --;
                    while (start<end && nums[start]== nums[start-1]){
                        start++;
                    }

                    while(start<end && nums[end] == nums[end+1]){
                        end --;
                    }
                }
                else if(nums[start]+nums[end] < target){
                    start++;
                }                
                else {
                    end -- ;
                }                
            }
        }
        return result;
    }
}
