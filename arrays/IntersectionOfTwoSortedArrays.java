import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class IntersectionOfTwoSortedArrays{


/**
 * Approach 1: Brute Force
 *
 * Idea:
 * - For every element in nums1,
 *   check if it exists in nums2.
 * - If found and not already used,
 *   add it to the result.
 *
 * We use a "seen" array to make sure
 * the same element in nums2 is not reused.
 *
 * Since arrays are sorted:
 * - If nums2[j] becomes greater than nums1[i],
 *   we break early (no need to check further).
 *
 * Time Complexity:
 * - O(n1 * n2) in worst case
 *
 * Space Complexity:
 * - O(n2) for seen array
 *
 *
 * Approach 2: Two Pointer (Optimal)
 *
 * Since both arrays are sorted,
 * we can use two pointers.
 *
 * Let:
 * - i → pointer for nums1
 * - j → pointer for nums2
 *
 * While both pointers are inside array:
 *
 * 1. If nums1[i] == nums2[j]:
 *      - Add element to result
 *      - Move both pointers
 *
 * 2. If nums1[i] < nums2[j]:
 *      - Move i forward
 *
 * 3. If nums1[i] > nums2[j]:
 *      - Move j forward
 *
 * This way we:
 * - Compare elements only once
 * - Maintain duplicate count correctly
 *
 * Time Complexity:
 * - O(n1 + n2)
 *
 * Space Complexity:
 * - O(1) (excluding result list)
 *
 *
 * Why Two Pointer is Better:
 * - We don't compare every pair.
 * - We move step-by-step like merge process.
 * - Much faster than brute force.
 *
 */

    public static List<Integer> Bruteforce(int[] nums1, int[] nums2){
        int[] seen = new int[nums2.length];
        List<Integer> intersection = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j] && seen[j] == 0){
                    intersection.add(nums1[i]);
                    seen[j] = 1;
                    break;
                }
                if(nums2[j] > nums1[i]){
                    break;
                }
            }
        }
        return intersection;
    }

    public static List<Integer> Intersection(int[] nums1, int[] nums2){
        List<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                intersection.add(nums1[i]);
                i++;
                j++;
            }
             else if(nums1[i] < nums2[j]){
                i++;   
            }
            else{
                j++;   
            }
        }
        return intersection;
    }


     public static void main(String[] args){
        int[] nums1 = {1,2,2,3,3,4,5,6};
        int[] nums2 = {2,3,3,5,6,6,7};

        System.out.println(Bruteforce(nums1,nums2));
        System.out.println(Intersection(nums1,nums2));

    }
}