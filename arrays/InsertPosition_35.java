class InsertPosition_35{

/**
 * Approach:
 * 
 * We use Binary Search since the array is sorted.
 * 
 * We maintain two pointers:
 * 1. left  → start of array
 * 2. right → end of array
 *
 * At each step:
 * - Find mid index.
 * - If nums[mid] == target → return mid.
 * - If nums[mid] > target → search left half.
 * - If nums[mid] < target → search right half.
 *
 * If the target is not found,
 * the loop ends when left > right.
 * At that point, left represents the correct
 * insertion position of the target.
 *
 *
 * Time Complexity: O(log n)
 *  - We divide the search space in half each time.
 *
 * Space Complexity: O(1)
 *  - No extra space is used except variables.
 *
 * Brute Force Complexity:
 *  - Time: O(n)
 *    - Linear search through the array.
 *  - Space: O(1)
 */

    public static int Bruteforce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {      // search left
                right = mid - 1;
            } else if (nums[mid] < target) {  // search right
                left = mid + 1;
            } else {
                return mid;   // found
            }
        }

        return left;  // insertion position
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(Bruteforce(nums, 2));
        System.out.println(searchInsert(nums, 2));
    }
}


