public class MaximumConsecutiveOnes{

    public static int findMaxOnes(int[] nums){
        int count = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max, count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {1,1,0,0,1,1,1,0,1,1};
        System.out.println(findMaxOnes(nums));
        
    }
}