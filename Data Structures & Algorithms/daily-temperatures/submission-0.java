class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int [] result = new int [temperatures.length];
        for(int i=1; i<temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int j = stack.pop();
                result [j] = i-j;
            }
            stack.push(i);
        }
        return result;
    }
}