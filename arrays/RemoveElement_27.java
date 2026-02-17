public class RemoveElement_27{

/**
 * Approach:
 * Its similar problem like problem no 26,but here we remove the value passsed in a function where we write the logic for.
 * we need to move the value given to the end and other elements of array should be in first and return the ending index of that subarrayarray excluding the value parts.
 * so we start by two pointer approach one pointer i at start and another at last j.
 * we compare the pointer nums[i] with the value given if we found match we will replace the value of nums[j] with the nums[i] and decrement the j by one.
 * atlast we return the j + 1.
 * 
 * 
 * Time Complexity: O(n)
 *  - We iterate once through the array.
 *
 * Space Complexity: O(1)
 *  - No extra space is used except variables.
 *
 * Brute Force Complexity:
 *  - Time: O(n^2)
 *  - Space: O(1)
 */

    public int bruteForce(int[] nums, int val) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {

                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }

                n--;
                i--;
            }
        }

        return n;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeElement(nums, 3));
    }
}