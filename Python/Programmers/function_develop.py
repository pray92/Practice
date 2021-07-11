

def solution(progresses, speeds):
	answer = []

	release_date = []
	for p, s in zip(progresses, speeds):
		if (100 - p) % s == 0:
			release_date.append((100 - p) // s)
		else:
			release_date.append((100 - p) // s + 1)

	offset_date, offset = release_date[0], 1
	for i, date in enumerate(release_date):
		if i < len(release_date) - 1:
			if offset_date > release_date[i + 1]:
				offset += 1
			else:
				answer.append(offset)
				offset_date, offset = release_date[i + 1], 1
		else:
			answer.append(offset)

	return answer

if __name__ == '__main__':
	print(solution([93, 30, 55], [1, 30, 5]))
	print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]))
	print(solution([99, 99, 99], [1, 1, 1]))
  	