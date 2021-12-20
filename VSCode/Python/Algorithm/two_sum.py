
def two_sum(nums, target):
    for i, n in enumerate(nums):
        complement = target - n

        if complement in nums[i + 1:]:
            return [nums.index(n), nums[i + 1:].index(complement) + (i + 1)]

def two_sum_2(nums, target):
    nums_map = {}
    
    # 키와 값을 바꿔서 딕셔너리 저장
    for i, n in enumerate(nums):
        nums_map[n] = i
    
    # 타겟에서 첫 번째 수를 뺀 결과를 키로 조회
    for i, num in enumerate(nums):
        if target - num in nums_map and i != nums_map[target - num]:
            return [i, nums_map[target - num]]

    del nums_map

    # 다른 방법(for문 통합)
    for i, num in enumerate(nums):
        if target - num in nums_map:
            return [nums_map[target - num], i]
        nums_map[num] = i

# 해당 로직은 오름차순으로 정렬이 되었을 경우에만 가용
def two_sum_3(nums: list, target: int) -> list:
    left, right = 0, len(nums) - 1
    while not left == right:
        # 합이 타겟보다 작으면 왼쪽 포인터를 오른쪽으로
        if nums[left] + nums[right] < target:
            left += 1
        # 합이 타겟보다 클 경우 오른쪽 포인터를 왼쪽으로
        elif nums[left] + nums[right] > target:
            right -= 1
        else:
            return [left, right]

if __name__ == "__main__":
    print(two_sum([2, 7, 11, 15], 9))
    print(two_sum_2([2, 7, 11, 15], 9))
    print(two_sum_3([2, 7, 11, 15], 9))
