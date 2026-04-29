class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        foundZero = False
        product = 1
        for num in nums:
            if num == 0:
                if foundZero == True:
                    return [0] * len(nums)
                foundZero = True
            else:
                product *= num
        result = []
        for num in nums:
            if num == 0:
                result.append(product)
            elif foundZero:
                result.append(0)
            else:
                result.append(product // num)
        return result
