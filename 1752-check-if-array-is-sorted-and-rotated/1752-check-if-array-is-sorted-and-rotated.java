class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return true;
        }
        int x = 0;
        for(int i = 0; i < n-1; i++){
            if(nums[i+1]<nums[i]){
                x = (n-i)-1;
            }
        }

        int[] b = new int[n];

        int idx = 0;
        while(idx < n){
            int temp = (idx+x) % n;
            b[temp]  = nums[idx];
            idx++;
        }

        for(int i = 1; i < n; i++){
            if(b[i] < b[i-1])
                return false;
        }
        return true;
    }
}