class Solution {
    public int minOperations(String[] logs) {
        // return usingStack(logs);
        return withoutStack(logs);
    }

    int usingStack(String[] logs){
        Stack<String> stack = new Stack<>();

        for(String str : logs){
            if(str.equals("./")){
                continue;
            }else if(str.equals("../")){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    continue;
                }
            }else{
                stack.push(str);
            }
        }
        return stack.size();
    }
    int withoutStack(String[] logs){
        int count = 0;

        for(String str : logs){
            if(str.equals("./")){
                continue;
            }else if(str.equals("../")){
                if(count == 0){
                    continue;
                }else{
                    count--;
                }
            }else{
                count++;
            }
        }
        return count;
    }
}