class Solution {
    public int[] productExceptSelf(int[] nums) {

        int [] prefix = new int [nums.length];
        int [] postfix = new int [nums.length];
        int currentProduct = 1;
        for(int i = 0; i<nums.length;i++){
            currentProduct*=nums[i];
            prefix[i] =currentProduct;
        }
        currentProduct = 1;
        postfix[nums.length-1] = nums[nums.length-1];
        for(int i =nums.length-1; i>=0;i--){
            currentProduct*=nums[i];
            postfix[i] =currentProduct;
        }

        int [] result = new int [nums.length];

        for(int i = 0; i<nums.length; i++){

            int prefixValue = i == 0 ? 1 : prefix[i - 1];
            int postfixValue = i == nums.length-1 ? 1 : postfix[i + 1];
            result [i] = prefixValue * postfixValue;
        }

        return result;
    }
}  
