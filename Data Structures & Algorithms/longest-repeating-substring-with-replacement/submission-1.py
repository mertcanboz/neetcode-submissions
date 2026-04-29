class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        counts = [0] * 26
        left = 0
        max_length = 0
        max_frequency = 0
        for right, ch in enumerate(s):
            counts[ord(ch)-ord('A')] += 1
            max_frequency = max(max_frequency, counts[ord(ch)-ord('A')])
            while (right - left + 1 - max_frequency) > k:
                counts[ord(s[left])-ord('A')] -= 1
                max_frequency = max(max_frequency, counts[ord(s[left])-ord('A')])
                left += 1
            max_length = max(max_length, right-left+1)
        return max_length