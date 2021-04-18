# 투 포인터로 합 계산
def three_sums(nums: list, target: int) -> list:
    results = []
    nums.sort() # Timsort

    # 중복된 값 건너뛰기
    for i in range(len(nums) - 2):
        if i > 0 and nums[i] == nums[i - 1]:
            continue

        # 간격을 좁혀가며 합 sum 계산
        left, right = i + 1, len(nums) - 1
        while left < right:
            sum = nums[i] + nums[left] + nums[right]
            if sum < target:
                left += 1
            elif sum > target:
                right -= 1
            else:
                # sum = 0 인 경우
                # 정답 및 스킵 처리
                results.append([ nums[i], nums[left], nums[right]])

                while left < right and nums[left] == nums[left + 1]:
                    left += 1

                while left < right and nums[right] == nums[right - 1]:
                    right -= 1
                
                left += 1
                right -= 1
                
    return results



if __name__ == "__main__":
    print(three_sums([-1, 0, 1, 2, -1, -4], 0))