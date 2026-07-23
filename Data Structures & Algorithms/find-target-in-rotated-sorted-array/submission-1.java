class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        int result = binarySearch (0, pivot-1, nums, target);
        if(result !=-1){
            return result;
        }
        return binarySearch (pivot, nums.length-1, nums, target);
    }

    private int findPivot(int [] nums){
        int low = 0, high = nums.length-1;

        while(low<high){
            int mid = low+(high - low) /2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }

            else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(int low, int high, int []nums, int target){
        while(low<=high){
            int mid = low+ (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
