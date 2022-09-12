class Solution {
    public int wiggleMaxLength(int[] nums) {
        int count = 0;
        boolean isPositive = false;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            boolean isCurPositive = diff > 0;
            
            if (diff != 0 && (count == 0 || isPositive != isCurPositive)) {
                count++;
                isPositive = diff > 0;
            }
        }
        
        return count + 1;
    }
}