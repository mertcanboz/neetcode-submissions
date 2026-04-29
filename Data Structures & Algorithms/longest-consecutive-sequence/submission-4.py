class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        set_numbers = set(nums)
        longest = 0
        for num in nums:
            if num in set_numbers:
                set_numbers.remove(num)
                greater = num + 1
                above = 0
                while greater in set_numbers:
                    above += 1
                    set_numbers.remove(greater)
                    greater += 1
                smaller = num - 1
                below = 0
                while smaller in set_numbers:
                    below += 1
                    set_numbers.remove(smaller)
                    smaller -= 1
                longest = max(longest, above+below+1)
        return longest