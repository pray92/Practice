import itertools
import math

def is_prime(num):
	for n in range(2, int(math.sqrt(num) + 1)):
		if num % n == 0:
			return False
	return True

def solution(nums):
	answer = 0
	for n1, n2, n3 in list(itertools.combinations(nums, 3)):		
		if is_prime(sum([n1, n2, n3])):
			answer += 1

	return answer

if __name__ == '__main__':
	print(solution([1,2,3,4]))
	print(solution([1,2,7,6,4]))