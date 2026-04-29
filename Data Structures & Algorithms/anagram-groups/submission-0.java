class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            map.computeIfAbsent(new String(arr), a -> new ArrayList<>()).add(str);
        }
    
    List<List<String>> result = new ArrayList<>();
    for (String key: map.keySet())
        result.add(map.get(key));
    return result;
    }
}
