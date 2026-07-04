class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        while (low<high){
            int mid = low +(high-low)/2;
            if (nums[mid] <= nums[high]){
                high = mid;
            }
            if(nums[mid]>nums[high]){
                low = mid + 1;
            }
        }
        int pivot = low;

        int result = binarySearch(nums, pivot, nums.length-1 , target);
        if( result!= -1){
            return result;
        }
        else {
            return binarySearch(nums, 0, pivot-1, target);
        }

    }

    public int binarySearch(int [] nums, int low, int high, int target){

        while (low<=high){
            int mid = low+(high-low)/2;
            if (target == nums[mid]){
                return mid;
            }
            if(target<nums[mid]){
                high = mid-1;
            }
            if(target > nums[mid]){
                low = mid+1;
            }
        }
        return -1;
    }
}
