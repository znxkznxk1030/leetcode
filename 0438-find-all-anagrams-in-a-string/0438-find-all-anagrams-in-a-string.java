class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Set<String> cache = new HashSet<>();
        
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String sub = s.substring(i, i + p.length());
            
            if (cache.contains(sub) || isMatch(s.substring(i, i + p.length()), p) ) {
                result.add(i);
                cache.add(sub);
                while(s.length() < i + p.length() && s.charAt(i) == s.charAt(i + p.length())) {
                    result.add(++i);
                }
            }
        }
        
        return result;
    }
    
    private boolean isMatch(String str1, String str2) {
        char[] chArr1 = str1.toCharArray();
        Arrays.sort(chArr1);
        char[] chArr2 = str2.toCharArray();
        Arrays.sort(chArr2);
        return Arrays.equals(chArr1, chArr2);
    }
}