char* removeOuterParentheses(char* s) {
    char *a = (char*)calloc(strlen(s), sizeof(char));    
    int i=0,top=-1;
    while(*s)
    {
        if(*s== '(')
        {
            top++;
            if(top>=1)
            {
                a[i++]= *s;
            }
        }
        else{
            if(top>=1)
            {
                a[i++] = *s;
            }
            top--;
        }
        s++;
    }
    a[i] = '\0';
    return a;
}