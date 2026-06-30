class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int p : piles) high = Math.max(high, p);  

        while (low<high){
            int mid = low+(high-low)/2;
            if (possible(piles,mid,h)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return high;
    }

    public boolean possible (int[] piles, int k, int hours){
    int result =0;

    for(int i =0; i<piles.length;i++){
        result+= (piles[i]+k-1)/k;
     }
        if(result<=hours){
        return true;
     }
     return false;
    }
}
