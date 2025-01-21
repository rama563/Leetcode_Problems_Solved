int fib(int n){
    int p1=0,p2=1,c=0;
if(n==1||n==0) return n;
else{
    for(int i=2;i<=n;i++)
    {
        c=p1+p2;
        p1=p2;
        p2=c;
    }
}
return p2;
}