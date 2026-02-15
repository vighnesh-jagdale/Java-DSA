import java.util.HashMap;

/**
 * Approach:
 * Use HashMap to store value → index mapping.
 * For each element, compute complement = target - nums[i].
 * If complement exists in map, return indices.
 * Otherwise, store current element in map.
 *
 * Time Complexity: O(n)
 *  - We iterate once through the array.
 *  - HashMap operations (put/get/containsKey) are O(1) average.
 *
 * Space Complexity: O(n)
 *  - In worst case, we store all elements in the HashMap.
 *
 * Brute Force Complexity:
 *  - Time: O(n^2)
 *  - Space: O(1)
 */

public class TwoSum_1 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {11,15,2,7};
        int target = 9;

        int[] result = twoSum(nums, target);

        for(int index : result) {
            System.out.println(index);
        }
    }
}