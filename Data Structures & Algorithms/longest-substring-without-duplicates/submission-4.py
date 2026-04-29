class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        i = 0
        j = 0
        n = len(s)
        max_length = 0
        while j < n:
            if s[j] in seen:
                while i < j and s[j] in seen:
                    seen.discard(s[i])
                    i += 1
            seen.add(s[j])
            j += 1
            max_length = max(j-i, max_length)
        return max_length