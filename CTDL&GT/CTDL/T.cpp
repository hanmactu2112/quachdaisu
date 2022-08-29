class Solution {
public:
    int trap(vector<int>& height) {
        if (not height.size()) return 0;
        int l = 0;
        int r = height.size() - 1;
        int left_max = 0, right_max = 0;
        int ret = 0;
            
        while ( l < r ) {
            if (height[l] < height[r]) {            // right will trap
                left_max = max(left_max, height[l]);
                ret =ret+ left_max - height[l];
                l++;
            }
            else {                                  // left will trap
                right_max = max(right_max, height[r]);
                ret =ret+ right_max - height[r];
                r--;
            }
        }
        return ret;
    }
};