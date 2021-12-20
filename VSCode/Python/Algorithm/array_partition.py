def array_partition(nums: list) -> int:
    sum = 0
    pair = []
    nums.sort()

    # 1안
    for n in nums:
        # 앞에서부터 오름차순으로 페어를 만들어 합 계산
        pair.append(n)
        if len(pair) == 2:
            sum += min(pair)
            pair = []

    # 2안 - 짝수 번째 값의 합 계산
    sum = 0
    pair = []
    for i, n in enumerate(nums):
        if i % 2 == 0:
            sum += n
    return sum

def array_partition_pythonic(nums: list) -> int:
    return sum(sorted(nums)[::2])

if __name__ == "__main__":
    print(array_partition([1, 4, 3, 2]))
