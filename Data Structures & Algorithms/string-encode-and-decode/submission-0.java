class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strs.size(); i++) {
            String str = strs.get(i);
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
            sb.append('#');
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i=0;
        char[] arr = str.toCharArray();
        while (i<arr.length) {
            int length = 0;
            while (arr[i] != '#') {
                length *= 10;
                length += arr[i++] - '0';
            }
            i++;
            StringBuilder sb = new StringBuilder();
            for (int k=0; k<length; k++) {
                sb.append(arr[i++]);
            }
            i++;
            list.add(sb.toString());
        }
        return list;
    }
}
