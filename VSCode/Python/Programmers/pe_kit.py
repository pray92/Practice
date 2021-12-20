import collections

def solution(n, lost, reserve):
	answer = 0
		
	clothes = [1 for _ in range(n + 1)]
	for i in range(1, n + 1):
		if i in lost:
			clothes[i] -= 1
		if i in reserve:
			clothes[i] += 1

	for i in range(1, n + 1):
		if clothes[i] <= 0:
			if i > 1 and clothes[i - 1] > 1:
				clothes[i - 1] -= 1
				clothes[i] += 1
			elif i < n and clothes[i + 1] > 1:
				clothes[i + 1] -= 1
				clothes[i] += 1

	clothes = clothes[1:]
	for cloth in clothes:
		if cloth > 0 : answer += 1
	return answer

if __name__ == '__main__':
	print(solution(5, [2, 4], [1, 3, 5]))
	print(solution(5, [2, 4], [3]))
	print(solution(3, [3], [1]))