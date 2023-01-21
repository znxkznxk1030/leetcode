class Solution {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(new ArrayList(), s, 1);
    }

    private List<String> restoreIpAddresses(List<Integer> ip, String remains, int index) {
        List<String> ret = new ArrayList<>();

        if (index == 4 && remains.length() <= 3 && remains.length() >= 1) {
            if (remains.length() > 1 && remains.startsWith("0")) return ret;
            List<Integer> copyedIp = ip.stream().collect(Collectors.toList());
            Integer digit = Integer.parseInt(remains);
            if (digit > 255) return ret;

            copyedIp.add(digit);
            ret.add(copyedIp.stream().map(String::valueOf).collect(Collectors.joining(".")));
        }

        if(index >= 4) {
            return ret;
        }

        for(int i = 1; i <= 3; i++) {
            if (remains.length() < i) continue;
            String remain = remains.substring(0, i);
            if (remain.length() > 1 && remain.startsWith("0")) continue;
            Integer digit = Integer.parseInt(remains.substring(0, i));
            if (digit > 255) continue;

            List<Integer> copyedIp = ip.stream().collect(Collectors.toList());
            copyedIp.add(digit);
            ret.addAll(restoreIpAddresses(copyedIp, remains.substring(i), index + 1));
        }

        return ret.stream().distinct().collect(Collectors.toList());
    }
}