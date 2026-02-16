class FindAllDisappearedNumberFromArray_448{

/**
 * Approach:
 * 
 * Since the array contains numbers in range 1 to n,
 * we can use the index of the array to mark which numbers exist.
 * For each number:
 * - Take absolute value → index = abs(nums[i]) - 1
 * - Mark nums[index] as negative (to indicate presence)
 *
 * After marking:
 * - Any index that still contains a positive value
 *   means (index + 1) is missing.
 *
 * This works because:
 * - We are using the input array itself as a hash structure.
 * - No extra space is needed (except output list).
 *
 *
 * Time Complexity: O(n)
 *  - First pass to mark.
 *  - Second pass to collect results.
 *
 * Space Complexity: O(1)
 *  - No extra space used (excluding result list).
 *
 * Brute Force Complexity:
 *  - Time: O(n^2)
 *    - For each number from 1 to n, check if it exists in array.
 *  - Space: O(1)
 */

    public List<Integer> findDisappearedNumbersBrute(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            boolean found = false;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // Mark indices
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Collect missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}




    
}