class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        
        if (isPalindrome(s)) {
            ret.add(Arrays.asList(s));
        }
        
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(0, i);
            
            if (!isPalindrome(sub)) {
                continue;
            }
            
            if (i < s.length() ) {
                List<List<String>> palindromeList = partition(s.substring(i));
                
                for (List<String> palindrome: palindromeList) {
                    List<String> _palindrome = new ArrayList<>();
                    _palindrome.add(sub);
                    _palindrome.addAll(palindrome);
                    ret.add(_palindrome);
                }
            }
        }
        
        return ret;
    }
    
    private boolean isPalindrome(String str) {
        for(int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }
        
        return true;
    }
}