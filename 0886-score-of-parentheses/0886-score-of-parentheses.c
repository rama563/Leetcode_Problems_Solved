int scoreOfParentheses(char* s) {
    int score = 0;
    int depth = 0;
    for (int i = 0;s[i];i++)
    {
        if (s[i]=='(')
            depth++;
        else
        {
            depth--;
            if (s[i-1]=='(')
            {
                int add = 1;
                for (int j =0;j<depth;j++)
                {
                    add*=2;
                }
                score+=add;
            }
        }
    }
    return score;
}