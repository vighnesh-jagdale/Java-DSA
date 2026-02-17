public class RotateArrayByK{

/**
 * Approach:
 * Rotate array by k place may be tricky sometimes but its the one of the easiest problem.
 * We had given an array and we need to rotate it by k place k may be any integer and in any driection left or right.
 *  The approach is very simple:
 *  1) For left rotation we reverse the element from 0 to K.
 *  2) Then reverse the elements from k to N, N is the size of array which points to the end of array.
 *  3) Then At last we reverse the whole array which gives us the resultant for Left rotation of array by K.
 * 
 * Same approach for the right rotation only the order changes,
 *  1) Here first we reverse the whole array.
 *  2) Then we reverse the array till first k elements.
 *  3) Now Reverse from k to n.
 * 
 * Here are some edge cases:
 *  1) Suppose the k is 15 and element (n) is 7 so we rotate the array by one place only why? because 7 + 7 = 14 when we rotate by 7 we get the same array no change in it hence by doing 7 + 7 twice we get same so no need to perform operation we only care about the 1 rotation.
 *  2) So we do k = k % n which tells how many times to rotate array.
 * 
 * 
 * Time Complexity: O(2n)
 *  - We iterate once through the array.
 *
 * Space Complexity: O(1)
 *  - No extra space is used we rotated the array in place.
 *
 */

    public static void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return;

        k = k % n;
        if(k == 0) return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void rotateRight(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return;

        k = k % n;
        if(k == 0) return;

        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args){
        int[] nums1 = {1,2,3,4,5,6,7};
        int[] nums2 = {1,2,3,4,5,6,7};
        rotateLeft(nums1, 3);
        for(int num:nums1){
            System.out.print(num + " ");
        }

        System.out.println();

        rotateRight(nums2, 3);
        for(int num:nums2){
            System.out.print(num + " ");
        }
    }
}