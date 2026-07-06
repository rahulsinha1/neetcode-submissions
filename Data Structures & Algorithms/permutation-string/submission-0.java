class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int [] s1Frequency= new int [26];

        for (int i =0; i<s1.length();i++){
            s1Frequency[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = s1.length()-1;

        while(right<s2.length()){
            int [] frequency = new int [26];
            for(int i = left; i<=right;i++){
                frequency[s2.charAt(i)-'a']++;
            }

            if (compareArrays(s1Frequency, frequency)){
                return true;
            }
            else{
                left++;
                right++;
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
