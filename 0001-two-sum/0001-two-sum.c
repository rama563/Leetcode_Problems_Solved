/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* a, int n, int target, int* returnSize) {
    int* arr = (int*)malloc(2 * sizeof(int));

    for(int i=0;i<n-1;i++)
    {
        int compliment = target - a[i];
        for(int j=i+1;j<n;j++)
        {
            if(compliment == a[j])
            {
                arr[0] =i;
                arr[1] = j;
                break;
            }
        }
    }
    *returnSize = 2;
    return arr;
}