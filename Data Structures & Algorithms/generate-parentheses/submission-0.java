class Solution {
    public List<String> generateParenthesis(int n) {
        //close<open - then add close
        //open<n, then add open
        //string length 2*n - base condition for recursion

        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();

        generate (n, 0,0,sb,result);
        return result;
    }

    public void generate(int n, int open, int close, StringBuilder sb, List<String> result)
    {
        if (sb.length() == 2*n){
            result.add(sb.toString());
        }

        if(open<n){
            sb.append('(');
            generate(n, open+1,close,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(')');
            generate(n, open,close+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
