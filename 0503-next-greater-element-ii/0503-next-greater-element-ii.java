class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=0;i<nums.length*2;i++)
        {
            while(!s.isEmpty() && nums[s.peek()] < nums[i%nums.length])
            {
                res[s.pop()] = nums[i%nums.length];  
            }
                s.push(i%nums.length);
        }
        return res;
    }
}