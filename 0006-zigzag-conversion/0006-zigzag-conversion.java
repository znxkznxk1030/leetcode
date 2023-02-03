class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        char[][] zigzag = new char[numRows][1001];

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < 1000; j++) {
                zigzag[i][j] = ' ';
            }
        }

        int x = 0, y = -1;
        boolean uprise = false;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (uprise == true) {
                zigzag[--y][++x] = ch;
                if (y <= 0) {
                    uprise = false;
                }
            } else {
                zigzag[++y][x] = ch;
                if (y + 1 >= numRows) {
                    uprise = true;
                }
            }
        }

        String result = "";

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < 1000; j++) {
                if (zigzag[i][j] != ' ') {
                    result = result + zigzag[i][j];
                }
            }
        }

        return result;
    }
}