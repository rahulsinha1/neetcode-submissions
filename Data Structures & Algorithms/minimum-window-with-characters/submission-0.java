class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        int substringLength = Integer.MAX_VALUE;
        Map<Character, Integer> frequency = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()){
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;

        while (r<s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while(frequencyMatches(map, frequency)){
                String substring = s.substring(l,r+1);
                if(substring.length()<substringLength){
                    result = substring;
                    substringLength = result.length();
                }

                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }
        return result;
    }
    private boolean frequencyMatches(Map<Character, Integer> map, Map<Character, Integer> frequency) {
    for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
        if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
            return false;
        }
    }
    return true;
}
}
