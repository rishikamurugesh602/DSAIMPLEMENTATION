class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = search(target, nums, true);   // first index
        ans[1] = search(target, nums, false);  // last index

        return ans;
    }

    int search(int target, int[] nums, boolean firststartindex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;//can be the ans
                if (firststartindex) {
                    end = mid - 1;   
                } else {
                    start = mid + 1; 
                }
            }
        }
        return ans;
    }
}
