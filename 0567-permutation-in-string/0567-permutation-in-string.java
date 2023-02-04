class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            if (isMatch(s1, s2.substring(i, i + s1.length()))) return true;
        }
        
        return false;
    }
    
    public boolean isMatch(String src, String dst) {
        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();
        
        Arrays.sort(srcArr);
        Arrays.sort(dstArr);
        
        return Arrays.equals(srcArr, dstArr);
    }
}