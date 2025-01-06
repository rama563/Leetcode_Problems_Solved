int singleNumber(int* nums, int n) {
    int r=0;
    for(int i=0;i<n;i++){
        r = r ^ nums[i]; 
    }
    return r;
}