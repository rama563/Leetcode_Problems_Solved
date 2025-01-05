class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        unordered_map<double,int>map;
        long long pc=0;
        for(auto i:rectangles)
        {
            double ratio = (double)i[0]/i[1];
            pc= pc+map[ratio];
            map[ratio]=map[ratio]+1;
        }
        return pc;
    }
};