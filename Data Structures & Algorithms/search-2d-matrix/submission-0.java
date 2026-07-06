class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n-1;

        while (low<=high){
            int mid = low+(high-low)/2;
            int currentElement = matrix[mid/n][mid%n];

            if (currentElement == target){
                return true;
            }
            else if (currentElement<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}
