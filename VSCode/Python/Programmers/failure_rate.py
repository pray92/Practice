#import numpy as np

def solution(N : int, stages : list):
	answer = {}

	for stage in range(1, N + 1):
		cleared, reached = len([x for x in stages if x >= stage]), stages.count(stage)
		if cleared == 0:
			answer[stage] = 0.0
		else:
			answer[stage] = float(reached / cleared)
	print(answer)
	return [x for x, _ in sorted(answer.items(), key= lambda x: x[1], reverse=True)]


if __name__ == '__main__':
	print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
	print(solution(4, [4,4,4,4,4]))