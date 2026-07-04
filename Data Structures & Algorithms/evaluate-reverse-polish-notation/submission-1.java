class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int a =0;
        int b =0;
        for (String token : tokens){
            switch(token){
                case "+" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a+b);
                    break;
                case "-" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b-a);
                    break;
                case "/" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;
                case "*" :
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a*b);
                    break;
                default:
                    a = Integer.parseInt(token);
                    stack.push(a);                                                      
            }
        }
        return stack.pop();
    }
}
