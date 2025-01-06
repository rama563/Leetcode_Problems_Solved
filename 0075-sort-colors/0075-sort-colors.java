class Solution {
    public void sortColors(int[] a) {
        int zc=0,oc =0,tc=0;
        int n = a.length ;
        for(int i=0;i<n;i++){
            if(a[i] == 0) zc++;
            if(a[i] == 1) oc++;
            if(a[i] == 2) tc++;
        }
        for(int i=0;i<zc;i++)
        {
            a[i] = 0;
        }
        for(int i=zc;i<oc+zc;i++)
        {
            a[i] = 1;
        }
        for(int i=oc+zc;i<n;i++)
        {
            a[i] = 2;
        }
    }
}