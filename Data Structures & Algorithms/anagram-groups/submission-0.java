class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            String strHash = createKey(str);

            if(map.containsKey(strHash)){
                map.get(strHash).add(str);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(strHash, list);
            }
        }
        List<List<String>> groupAnagrams = new ArrayList<>();
        for (List<String> value: map.values()){
            groupAnagrams.add(value);
        }
        return groupAnagrams;
    }

    private String createKey(String str){
        int [] frequency = new int [26];

        for (char c: str.toCharArray()){
            frequency[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<26;i++){
            sb.append(frequency[i]).append('#');
        }
        return sb.toString();
    }
}
