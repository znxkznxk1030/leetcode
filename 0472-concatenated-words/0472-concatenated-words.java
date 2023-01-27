class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length()- s2.length();
            }
        });

        for (String word: words) {
            // System.out.println(word);
            List<Integer> pivotList = new ArrayList<>();
            pivotList.add(0);
            
            for(int i = 0; i <= word.length(); i++) {
                for (int pivot: pivotList.stream().collect(Collectors.toList())) {
                    String tmp = word.substring(pivot, i);
                    if (wordSet.contains(tmp)) {
                        pivotList.add(i);
                        if (i == word.length()) {
                            System.out.println(word);
                            result.add(word);
                            break;
                        }
                    }
                }
            }

            wordSet.add(word);
        }

        // result = result.stream().distinct().collect(Collectors.toList());

        return result;
    }
}