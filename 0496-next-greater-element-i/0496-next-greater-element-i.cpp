class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,int> map;
        stack<int>s;
        for(auto e : nums2)
        {
            while(!s.empty() && s.top()<e){
                map[s.top()] = e;
                s.pop();
            }
            s.push(e);
        }
        while(!s.empty())
        {
            map[s.top()] = -1;
            s.pop();
        }
        vector<int> res(nums1.size());
        for (int i = 0; i < nums1.size(); ++i) {
            res[i] = map[nums1[i]];
        }
        
        return res;
    }
};