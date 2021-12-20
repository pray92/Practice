
first = [1,2,3,4,5]
second = [2,1,2,3,2,4,2,5]
third = [3,3,1,1,2,2,4,4,5,5]

def solution(answers):
	first_list = first * max(1, int(len(answers) / len(first)) + 1)
	first_correct = sum([1 for i, answer in enumerate(answers) if first_list[i] == answer]) 
	
	second_list = second * max(1, int(len(answers) / len(second)) + 1)
	second_correct = sum([1 for i, answer in enumerate(answers) if second_list[i] == answer])
	
	third_list = third * max(1, int(len(answers) / len(third)) + 1)
	third_correct = sum([1 for i, answer in enumerate(answers) if third_list[i] == answer])

	answer = []
	correct_list = [first_correct, second_correct, third_correct]
	for i, correct in enumerate(correct_list):
		if correct == max(correct_list):
			answer.append(i + 1)
	return answer

if __name__ == '__main__':
	print(solution([1,2,3,4,5]))
	print(solution([1,3,2,4,2]))