class Solution {
public:
    static bool comp(const string &s1, const string &s2) {
    return s1.length() < s2.length(); // Sort words by length
    }

    bool compare(string &s1, string &s2){
        if(s1.length() -1 != s2.length()) return false;

        int first =0;
        int second = 0;
        while(first != s1.length()){
            if(s1[first] == s2[second]){
                first++;
                second++;
            }
            else {
                first++;
            }
        }
        if(first == s1.length() && second == s2.length()) return true;
        return false;
    }
    int longestStrChain(vector<string>& words) {
        int n = words.size();
        if (n == 0) return 0;
        // sort(words.begin(),words.end(),comp);
        sort(words.begin(), words.end(), comp);
        vector<int>dp(n,1);

        int maxi = 1;
        for(int i = 0 ; i < n ; i++){
            for(int prev = 0 ; prev < i; prev++){

                if(compare(words[i],words[prev]) && 1+dp[prev] > dp[i]){
                    dp[i]  =  1 +dp[prev];
                }
            }
            maxi = max(maxi,dp[i]);
        }
        return maxi;
    }
};