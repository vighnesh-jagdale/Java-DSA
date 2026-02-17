public class RemoveDuplicatesFromSortedArray_26{

/**
 * Approach:
 * Used Two Pointer approach
 * We start one pointer i from start and j pointer from next to it.
 * we then compare the j with i
 *  - if i is equal to j : we do nothing only j++
 *  - if i is not eqaul to j : we increment i by one and store the j in i position as we dont care the other elements in the array after clearing the dplicates hence we dont swap them.
 * after at end we return the i + 1 which gives the number of distinct elements in array.
 *
 * Time Complexity: O(n)
 *  - We iterate once through the array.
 *
 * Space Complexity: O(1)
 *  - we dont need extra space as the operation is complete in-place.
 *
 * Brute Force Complexity:
 *  - Time: O(n^2)
 *  - Space: O(1)
 */


    public static int Bruteforce(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            if (nums[i] == nums[i + 1]) {

                for (int j = i + 1; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }

                n--;
                i--;      
            }
        }

        return n;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,4,3,2};
        System.out.println(Bruteforce(nums));
        System.out.println(removeDuplicates(nums));

    }

}