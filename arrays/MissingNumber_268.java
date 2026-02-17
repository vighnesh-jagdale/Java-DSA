import java.util.HashMap;

/**
 *
 *
 * Approach 1: Brute Force
 *
 * For every number from 0 to n:
 *   - Check if it exists in the array.
 *   - If not found, return it.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 *
 *  Approach 2: Using HashMap
 *
 * 1. Store all elements in a HashSet.
 * 2. Check from 0 to n:
 *      - If a number is not in the set,
 *        that is the missing number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 *
 * Approach 3: Using Sum Formula
 *
 * 1. Expected sum = n * (n + 1) / 2
 * 2. Find actual sum of array.
 * 3. Missing number = expected sum - actual sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 *
 *  Approach: Using XOR
 *
 * XOR Properties:
 *   a ^ a = 0
 *   a ^ 0 = a
 *
 * 1. XOR all numbers from 0 to n.
 * 2. XOR all elements in the array.
 * 3. Remaining value is the missing number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 */

class MissingNumber_268 {

    public static int missingNumber1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber2(int[] nums){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums[i], 1);
        }

        for(int i = 0; i <= n; i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber3(int[] nums){
        int numsSum = 0;
        int n = nums.length;
        int totalSum = n*(n + 1) / 2;

        for(int i = 0; i < n; i++){
            numsSum += nums[i];
        }

        return totalSum - numsSum;
    }

    public static int missingNumber4(int[] nums){
        int xor = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ n;
    }

    public static void main(String[] args){
        int[] nums = {1,0,4,2};

        System.out.println(missingNumber1(nums));
        System.out.println(missingNumber2(nums));
        System.out.println(missingNumber3(nums));
        System.out.println(missingNumber4(nums));
    }
}