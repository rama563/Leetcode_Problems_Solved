char* baseNeg2(int n) {
    static char a[100];  // Use static to persist outside the function
    int r = 0, j = 0;

    if (n == 0) {  // Handle case for 0
        a[j++] = '0';
        a[j] = '\0';
        return a;
    }

    while (n != 0) {
        r = n % -2;
        if (r < 0) {  // Adjust negative remainders
            r += 2;
            n = (n / -2) + 1;
        } else {
            n = n / -2;
        }
        a[j++] = (char)(r + '0');  // Store the digit as a character
    }

    a[j] = '\0';  // Null-terminate the string

    // Reverse the array to get the correct order
    for (int i = 0; i < j / 2; i++) {
        char temp = a[i];
        a[i] = a[j - i - 1];
        a[j - i - 1] = temp;
    }

    return a;
}