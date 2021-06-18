from collections import Counter

def solution(lottos, win_nums):
	includes = [x for x in lottos if x in win_nums]
	zero_cnt = len(list(filter(lambda x: x == 0, lottos)))

	return [min((6 - (len(includes) + zero_cnt)) + 1, 6), min((6 - len(includes)) + 1, 6)]

if __name__ == '__main__':
	print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]))
	print(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]))
	print(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]))