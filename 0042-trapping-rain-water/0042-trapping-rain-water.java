class Solution {
    public int trap(int[] height) {
        int l=0;
        int r= height.length-1,lm=0,rm=0,res=0;
        while(l<r)
        {
            if(height[l]<height[r])
            {
                if(lm<height[l]){
                    lm = height[l];
                }
                else{
                    res+=lm - height[l];
                }
                l++;
            }
            else{
                if(rm<height[r]){
                    rm = height[r];
                }
                else{
                    res+=rm - height[r];
                }
                --r;
            }
        }
        return res;
    }
}