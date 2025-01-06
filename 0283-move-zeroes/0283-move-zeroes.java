class Solution {
    public void moveZeroes(int[] nums) {
        int k=0,j=0;
        for(int i=0;i<nums.length;i++)
        {

            if(nums[i] == 0){
                k++;
            }
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }

        }
        for(int i =nums.length-k;i<nums.length;i++)
        nums[i] = 0;
    }
    // return nums;
}