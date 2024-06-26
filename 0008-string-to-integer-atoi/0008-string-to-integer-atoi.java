class Solution {
    public int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }
        s = s.strip();
        if(s.length()==0){
            return 0;
        }
        
        boolean neg = s.charAt(0) == '-' ? true:false;
        if(neg || s.charAt(0)== '+')
            s = s.substring(1,s.length());
        
        if(s.length()==0){
            return 0;
        }
        if(!Character.isDigit(s.charAt(0))) return 0;

        StringBuilder sb = new StringBuilder();
        boolean f = false;

        for(char ch : s.toCharArray()){
            if(ch == '0' && f == false){
                continue;
            }
            if(Character.isDigit(ch)){
                sb.append(ch);
                f = true;
            }else{
                break;
            }
            if(sb.length()>11 && neg){
                return Integer.MIN_VALUE;
            }else if(sb.length() > 11){
                return Integer.MAX_VALUE;
            }
        }
        if(sb.length()==0){
            return 0;
        }
        long ans = Long.parseLong(sb.toString());

        if(ans > Integer.MAX_VALUE && neg){
            return Integer.MIN_VALUE;
        }else if(ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }


        return neg? -((int)ans):(int)ans;
        
    }
}