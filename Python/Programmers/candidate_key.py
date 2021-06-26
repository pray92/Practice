
import numpy as np

def can_be_candidated(sub_relation):
	candidates = {}
	for keys in sub_relation:
		try: 
			candidates[tuple(keys)] += 1
		except: 
			candidates[tuple(keys)] = 1
			continue
		return False
	return True

def solution(relation):
	relation = np.array(relation)
	answer = 0
	
	done = [False for _ in range(len(relation[0]))]
	for col_index in range(len(relation[0])):
		if done[col_index]:
			continue
		
		col_values = relation[:, col_index]
		if can_be_candidated(col_values.tolist()):
			answer += 1
			done[col_index] = True
		else:
			for col_index2 in range(col_index + 1, len(relation[0])):
				col_values = relation[:, col_index:col_index2 + 1]
				if can_be_candidated(col_values.tolist()):
					answer += 1
					for to_true in range(col_index, col_index2 + 1):
						done[to_true] = True
					break

	return answer

if __name__ == '__main__':
	print(solution([
		["100", "ryan", "music", "2"],
		["200", "apeach", "math", "2"],
		["300", "tube", "computer", "3"],
		["400", "con", "computer", "4"],
		["500", "muzi", "music", "3"],
		["600", "apeach", "music", "2"]]))