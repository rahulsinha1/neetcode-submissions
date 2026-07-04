class Solution {
    public int maxArea(int[] heights) {
        int start = 0, end = heights.length-1;
        int maxArea = 0;
        while (start<end){
            int height = Math.min(heights[start], heights[end]);
            int width = end-start;
            int currentArea = height*width;
            maxArea = Math.max(currentArea, maxArea);

            if(heights[start]<=heights[end]){
                start ++;
            }
            else{
                end --;
            }
        }
        return maxArea;
    }
}
