char* convertToBase7(int num) {
    static char a[50];
    int r = 0,j=0;
    int m=-1,n=0;
    if(num<0)
    {
        num = m * num;
        n=1;
    }
    if(num == 0) return "0";

    while(num>0)
    {
        r = num%7 ;
        a[j++] =(char) (r + '0');
        num = num/7;
        if(num<7 && num>0)
        {
            a[j++]  = (char)(num+'0');
            break;
        }
    }
    if(n==1) a[j++] = '-';
    a[j] = '\0';
    for (int i = 0; i < j / 2; i++) {
        char temp = a[i];
        a[i] = a[j - i - 1];
        a[j - i - 1] = temp;
    }

    return a;
        // return a;
}