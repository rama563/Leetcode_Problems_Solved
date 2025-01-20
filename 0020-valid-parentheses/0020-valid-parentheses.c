bool isValid(char* s) {
    int size = strlen(s);
    int arr[size+1];
    int top=-1;
    for(int i=0;i<size;i++)
    {
        if(s[i]=='('||s[i]=='{'||s[i]=='[')
        {
            top++;
            arr[top] =s[i];
        }
        else if(top!=-1 &&( (s[i]==']'&& arr[top]=='[')||(s[i]==')'&& arr[top]=='(')||(s[i]=='}'&& arr[top]=='{')))
        {
            top--;

        }
        else{
            return false;
        }
    }
    if(top!=-1) return false;
    return true;
}