class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] result = new int [temperatures.length];

        for(int i =0;i<temperatures.length; i++){
           
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int currentIndex = stack.poll();
                result[currentIndex] = i-currentIndex;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.poll()] = 0;
        }
        return result;
    }
}
