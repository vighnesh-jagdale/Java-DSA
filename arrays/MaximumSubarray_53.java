public class MaximumSubarray_53{

/**
 * Approach:
 * For this problem we use the Kadanes Algorithm.
 * We need to find the maximum sum of subarray from the given array so iterating through array and summing the elements gives us bruteforce approach.
 * So the kadanes algorithm comes in play it basically means whenever a positive number is added into a negative number which is greater, than instead of adding it we make the sum 0,
 * Like suppose we added -5 + 4 the answer would be -1 so taking the -1 we take 0,
 * 
 * Time Complexity: O(n)
 *  - We iterate once through the array.
 *  - Math.max operations O(1).
 *
 * Space Complexity: O(1)
 *  - No extra space is used except variables.
 *
 * Brute Force Complexity:
 *  - Time: O(n^2)
 *  - Space: O(1)
 */

    public static int bruteForce(int[] nums) {
        int maxSum = nums[0];

        for (int start = 0; start < nums.length; start++) {
            int currSum = 0;
            for (int end = start; end < nums.length; end++) {
                currSum += nums[end];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static int kadanesAlgo(int[] nums) {
        int maxSum = nums[0];   
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] nums = {5,4,3,2,1};
        System.out.println(Bruteforce(nums));
        System.out.println(kadanesAlgo(nums));
    }
}