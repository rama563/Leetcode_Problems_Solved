/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void merge(int* arr ,int l,int mid,int r)
{
    int n1 = mid - l + 1;
    int n2 = r - mid;
    int lArr[n1],rArr[n2];
    for(int i=0;i<n1;i++)
        lArr[i] = arr[l+i];
    for(int i=0;i<n2;i++)
        rArr[i] = arr[mid+1+i];
    int i=0,j=0,k = l;
    while(i<n1 && j<n2)
    {
        if(lArr[i]<=rArr[j])
        {
            arr[k]=lArr[i];
            i++;
            k++;
        }
        else{

            arr[k]=rArr[j];
            j++;
            k++;
        }
    }
    while (i < n1) {
        arr[k] = lArr[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = rArr[j];
        j++;
        k++;
    }

}
void mergeSort(int* arr ,int l , int r)
{
    int mid=0;
    if(l<r)
    {
        mid = l + (r - l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);

    }
}
int* sortArray(int* nums, int ns, int* returnSize) {
    mergeSort(nums, 0 ,ns-1);
    *returnSize = ns;
    return nums;
}