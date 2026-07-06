class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;
        int [] s1Frequency= new int [26];

        for (int i =0; i<s1.length();i++){
            s1Frequency[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = s1.length()-1;

        int [] s2Frequency = new int [26];
        for (int i =left; i<=right;i++){
            s2Frequency[s2.charAt(i) - 'a']++;
        }
        while(right<s2.length()){
            if (compareArrays(s1Frequency, s2Frequency)){
                return true;
            }
            else{
                s2Frequency[s2.charAt(left)-'a']--;
                left++;
                right++;
            }
            if(right<s2.length()){
                s2Frequency[s2.charAt(right)-'a']++;
            }
        }
        return false;
    }

    public boolean compareArrays(int a[], int b[]){
        for (int i =0; i<26;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
