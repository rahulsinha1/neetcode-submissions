class Solution {
    public int jump(int[] nums) {
        int coverage = 0;
        int jumps = 0;
        int reach = 0;

        for(int i =0; i<nums.length-1; i++){
            coverage = Math.max(coverage, nums[i]+i);
            if(i == reach){
                jumps ++;
                reach = coverage;
            }
        }
        return jumps;
    }
}
