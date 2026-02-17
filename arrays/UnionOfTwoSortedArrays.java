import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Brute Force Approach:
 *
 * 1. Use a HashSet.
 * 2. Add all elements from nums1.
 * 3. Add all elements from nums2.
 * 4. Convert set to list.
 *
 * Since set stores only unique values,
 * duplicates are automatically removed.
 *
 * Time Complexity: O(n1 + n2)
 * Space Complexity: O(n1 + n2)
 *
 *
 * Optimal Approach (Two Pointer):
 *
 * Since arrays are sorted,
 * we can use two pointers.
 *
 * Let i for nums1 and j for nums2.
 *
 * Compare elements:
 *
 * - If nums1[i] < nums2[j],
 *      add nums1[i] and move i.
 *
 * - If nums1[i] > nums2[j],
 *      add nums2[j] and move j.
 *
 * - If equal,
 *      add once and move both.
 *
 * To avoid duplicates,
 * we check the last inserted value
 * before adding new one.
 *
 * After one array finishes,
 * add remaining elements of other array
 * while avoiding duplicates.
 *
 * Time Complexity: O(n1 + n2)
 * Space Complexity: O(1) (excluding result list)
 *
 */



public class UnionOfTwoSortedArrays{

    public static List<Integer> BruteForce(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        List<Integer> union = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
            set.add(nums2[i]);
        }

        for(int num : set){
            union.add(num);
        }
        return union;
    }

    public static List<Integer> UnionOfTwoSortedArraysOptimal(int[] nums1, int[] nums2){
        List<Integer> union = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length){
            int val;

            if(nums1[i] < nums2[j]){
                val = nums1[i];
                i++;
            }
            else if(nums1[i] > nums2[j]){
                val = nums2[j];
                j++;
            }
            else{
                val = nums1[i];
                i++;
                j++;
            }

            if(union.isEmpty() || union.get(union.size() - 1) != val){
                union.add(val);
            }
        }

        while(i < nums1.length){
            if(union.isEmpty() || union.get(union.size() - 1) != nums1[i]){
                union.add(nums1[i]);
            }
            i++;
        }

        while(j < nums2.length){
            if(union.isEmpty() || union.get(union.size() - 1) != nums2[j]){
                union.add(nums2[j]);
            }
            j++;
        }

        return union;
    }

    public static void main(String[] args){
        int[] nums1 = {1,1,2,3,4,5};
        int[] nums2 = {2,3,4,4,5};

        System.out.println(BruteForce(nums1,nums2));
        System.out.println(UnionOfTwoSortedArraysOptimal(nums1,nums2));
    }
}