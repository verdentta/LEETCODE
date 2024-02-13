class Solution {
    public int searchInsert(int[] nums, int target) {

        // let's try to do binary search way since it's faster and it is required
        // initialize our left and right pointers and mid variable as well

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        // run a while loop that looks through the target via binary search/divide and
        // conquer
        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // if the target wasn't found then we check if the target is either to the left
        // or right of the nums[mid] and return accordingly
        if (left >= right) {
            if (target > nums[mid]) {
                return mid + 1;
            } else {
                return mid;
            }
        }

        return 0;
    }
}