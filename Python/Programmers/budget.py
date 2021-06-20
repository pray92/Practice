import itertools

def solution(d : list, budget : int):
	d.sort()

	answer = 0
	cur_invest = 0
	for dd in d:
		cur_invest += dd
		if cur_invest > budget:
			break
		answer += 1
	
	return answer

if __name__ == '__main__':
	print(solution([1,3,2,5,4], 9))
	print(solution([2,2,3,3], 10))