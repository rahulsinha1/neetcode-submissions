class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;

        int result = 0;

        int currentMaxFrequency = 0;

        Map<Character, Integer> frequencyMap = new HashMap<>();

        while(r < s.length()){
            frequencyMap.put(s.charAt(r),
                frequencyMap.getOrDefault(s.charAt(r), 0) +1 );

            currentMaxFrequency = Math.max(currentMaxFrequency, frequencyMap.get(s.charAt(r)));
            
            if(r-l+1 - currentMaxFrequency > k){
                frequencyMap.put(s.charAt(l), frequencyMap.get(s.charAt(l)) - 1);
                l ++;
            }

            result = Math.max(result, r-l+1);
            r++;
        }

        return result;
    }
}
