class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> friends = new ArrayList<>();
        for(int i = 0; i < n; i++){
            friends.add(i+1);
        }
        int idx = 0;
        k = k-1;
        int ans = solve(friends, k, idx);
        return ans;
    }
    public int solve(ArrayList<Integer> list, int k, int idx){
        if(list.size() == 1){
            return list.get(0);
        }

        idx = (idx+k) %  list.size();
        list.remove(idx);
        return solve(list, k, idx);
    }
}