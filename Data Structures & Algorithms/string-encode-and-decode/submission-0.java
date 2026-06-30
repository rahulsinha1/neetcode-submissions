class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str: strs){
            encoded.append(str.length());
            encoded.append('#');
            encoded.append (str);
        }
        return encoded.toString();
    }

    public List<String> decode(String encoded) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while ( i<encoded.length()) {
            int j = encoded.indexOf('#', i);
            int strLength = Integer.parseInt(encoded.substring(i,j));

            String decodedString = encoded.substring(j+1, j+1+strLength);
            i = j+strLength+1;
            decoded.add (decodedString);
        }
        return decoded;
    }
}
