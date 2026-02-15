 public class MoveZeroes_283{

/**
 * Approach:
 * 
 * To move all zeroes to the end of the array while maintaining
 * the relative order of non-zero elements.
 *
 * Instead of moving zeroes, we move all non-zero elements forward.
 *
 * We maintain one pointer:
 * 
 * 1. insertPos → Represents the position where the next non-zero
 *    element should be placed.
 *
 * We iterate through the array:
 * - If nums[i] != 0:
 *      place it at nums[insertPos]
 *      increment insertPos
 *
 * After placing all non-zero elements in the front,
 * the remaining positions from insertPos to end
 * are filled with zero.
 *
 * This ensures:
 * - Order of non-zero elements remains unchanged.
 * - All zeroes move to the end.
 * - The operation is done in-place.
 *
 *
 * Time Complexity: O(n)
 *  - We iterate once through the array.
 *  - Each element is processed once.
 *
 * Space Complexity: O(1)
 *  - No extra space is used except variables.
 *
 * Brute Force Complexity:
 *  - Time: O(n^2)
 *    - If we shift elements every time a zero is found.
 *  - Space: O(1)
 */

 public void moveZeroes(int[] nums) {
        int insPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[insPos] = nums[i];
                ins++;
            }
        }

        while(insPos < nums.length){
            nums[insPos] = 0;
            ins++;
        }
    }

    public void moveZeroesSwapping(int[] nums) {
        int prev = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[prev];
                nums[prev] = nums[i];
                nums[i] = temp;
                prev++;
            }
        }
    }
}