int* getZArr(char *s, int sLength) {
    int *arr = (int*) malloc (sLength * sizeof(int));
    int left=0, right=0;
    arr[0] = 0;
    for (int i=1; i<sLength; i++) {
        int oldLeft = left, oldRight = right;

        if (i > right) {
            int j = i;
            for (; j < sLength && s[j] == s[j-i]; j++);
            arr[i] = j - i;
            left = i;
            right = j-1;   
        } else {
            if (arr[i-left] + i >= right) {
                left = i;
                for (; right+1 < sLength && s[right+1] == s[right+1-left]; right++);
                arr[i] = right - left + (right != left || s[right] == s[0]);
            } else {arr[i] = arr[i-left];
            }
        } 
    }

    return arr;
}

int repeatedStringMatch(char* a, char* b) {
    int aLen = strlen(a), bLen = strlen(b);
    int maxCount = bLen / aLen + 2;
    int strLen = bLen + maxCount * aLen + 1;
    char *str = (char*) malloc ((strLen + 1) * sizeof(char));
    strcpy(str, b);
    str[bLen] = '#';
    for (int i=0; i<maxCount; i++) 
        strcpy(str+(bLen+1+aLen*i), a);
    str[strLen] = '\0';

    int *arr = getZArr(str, strLen);

    for (int i=bLen+1; i<strLen; i++) 
        if (arr[i] == bLen) 
            return ceil((i - 1) / (double)aLen);
    return -1;
}