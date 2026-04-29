class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        seen = [0] * 26

        for char in s:
            seen[ord(char) - ord('a')] += 1

        for char in t:
            seen[ord(char) - ord('a')] -= 1
            if seen[ord(char) - ord('a')] < 0:
                return False

        for count in seen:
            if count > 0:
                return False

        return True