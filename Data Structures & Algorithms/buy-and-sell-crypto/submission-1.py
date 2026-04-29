class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minimum = float('inf')
        maximum = float('-inf')
        profit = 0
        for price in prices:
            if price < minimum:
                minimum = price
            elif price - minimum > profit:
                profit = price - minimum
        return profit