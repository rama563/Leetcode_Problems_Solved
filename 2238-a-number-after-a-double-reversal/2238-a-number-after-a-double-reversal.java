class Solution {
    public boolean isSameAfterReversals(int num) {
        int n = num;
        int s= 0;
        int s1= 0;

        while(n>0)
        {
            int r = n%10;
            s = s*10 + r;
            n/=10;

        }
        int n2 = s;
        while(n2>0)
        {
            int r = n2%10;
            s1 = s1*10 + r;
            n2/=10;
        }
        if (s1 == num) return true;
        return false;
    }
}