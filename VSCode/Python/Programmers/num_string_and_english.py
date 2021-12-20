from collections import deque

def string_to_num(s):
	if s == 'zero': return 0
	if s == 'one': return 1
	if s == 'two': return 2
	if s == 'three': return 3
	if s == 'four': return 4
	if s == 'five': return 5
	if s == 'six': return 6
	if s == 'seven': return 7
	if s == 'eight': return 8
	if s == 'nine': return 9
	return -1
	

def solution(s :str):
	answer = ''

	str_num = ''
	for sub_s in s:
		if '0' <= sub_s and sub_s <= '9':
			answer += sub_s
		else:
			str_num += sub_s
			num = string_to_num(str_num)
			if num >= 0:
				answer += str(num)
				str_num = ''

	return int(answer)

if __name__ == '__main__':
	print(solution("one4seveneight"))
	print(solution("23four5six7"))
	print(solution("2three45sixseven"))
	print(solution("123"))