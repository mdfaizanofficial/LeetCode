class Solution {
    public int kthGrammar(int n, int k) {
        return approach1(n, k);
    }
    
    int approach1(int n, int k){
        
        if(k == 1 && n ==1) return 0;
        
        
        int mid = ((int)Math.pow(2, n-1))/2;
        
        if(k <= mid){
            return approach1(n-1, k);
        }else{
            return ~approach1(n-1, k-mid)&1;
        }
    }
}