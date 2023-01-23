class Towner {
    int id;
    Map<Integer, Towner> trust;
    Map<Integer, Towner> trusted;
    
    Towner (int id) {
        this.id = id;
        trust = new HashMap<>();
        trusted = new HashMap<>();
    }
    
    public void addTrust(Towner towner) {
        if (towner.id == id) return;
        trust.putIfAbsent(towner.id, towner);
    }
    
    public void addTrusted(Towner towner) {
        if (towner.id == id) return;
        trusted.putIfAbsent(towner.id, towner);
    }
    
    public boolean isJudge(int n) {
        return trust.isEmpty() && trusted.size() == n - 1;
    }
}

class Solution {
    public int findJudge(int n, int[][] trusts) {
        Towner[] towners = new Towner[n + 1];
        
        for (int i = 1; i <= n; i++) {
            towners[i] = new Towner(i);
        }
        
        for (int[] trust: trusts) {
            towners[trust[0]].addTrust(towners[trust[1]]);
            towners[trust[1]].addTrusted(towners[trust[0]]);
        }
        
        int result = -1;
        
        for (int i = 1; i <= n; i++) {
            if (towners[i].isJudge(n)) {
                if (result != -1) return -1;
                result = i;
            }
        }
        
        return result;
    }
}