class Solution:
    def minWindow(self, s: str, t: str) -> str:
        counter_t = Counter(t)
        counter = Counter()
        left = 0
        candidate = None
        shortest_length = float('inf')
        for right, ch in enumerate(s):
            counter[ch] += 1
            while left <= right and counter[s[left]] > counter_t[s[left]]:
                counter[s[left]] -= 1
                left += 1
            if counter_t[ch] != 0 and Solution.contains(counter, counter_t) and right-left-1 < shortest_length:
                shortest_length = right-left-1
                candidate = (left, right)
        return "" if shortest_length == float('inf') else s[candidate[0]:candidate[1]+1]
    
    def contains(counter1, counter2):
        for key in counter2:
            if counter1[key] < counter2[key]:
                return False
        return True