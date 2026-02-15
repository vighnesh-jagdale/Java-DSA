import java.util.HashSet;
import java.util.Arrays;

/**
 * Approach:
 * Use HashSet to store value → index mapping.
 * For each element, see if the element is present in the set 
 * if yes then the number is repeated return true
 * or if not present then add it to set 
 * atlast after iterating thorugh every element and any number is not repeated we can say that the numbers are distinct return false.
 *
 * Time Complexity: O(n)
 *  - We iterate once through the array.
 *  - HashSet operations (add/containsKey) are O(1) average.
 *
 * Space Complexity: O(n)
 *  - In worst case, we store all elements in the HashSet so no unique element.
 *
 * Brute Force Complexity:
 *  - Time: O(n^2)
 *  - Space: O(1)
 */

public class ContainsDuplicate_217 {

    public static boolean Bruteforce(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean Optimized(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        System.out.println("Bruteforce Result: " + Bruteforce(nums));
        System.out.println("Optimized Result: " + Optimized(nums));
    }
}