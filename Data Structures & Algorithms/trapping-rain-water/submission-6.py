class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        water = 0

        for i, h in enumerate(height):
            while stack and height[stack[-1]] < h:
                floor = stack.pop()
                if not stack:
                    continue
                back_wall = stack[-1]
                width = i - back_wall - 1
                depth = min(height[back_wall], h) - height[floor]
                water += width * depth
            stack.append(i)

        return water