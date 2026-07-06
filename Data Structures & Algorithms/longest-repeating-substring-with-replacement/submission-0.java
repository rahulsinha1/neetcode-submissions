class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int [] frequency = new int [26];
        int result = 0;
        for (int r = 0; r<s.length(); r++){
            frequency[s.charAt(r)-'A']++ ;
            int maxFreq = Arrays.stream(frequency).max().getAsInt();
            if (r-l+1-maxFreq > k){
                frequency[s.charAt(l)-'A']--;
                l++;
            }

            result = Math.max(result, r-l+1);
        }
        return result;
    }
}
