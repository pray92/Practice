dist = [[x, y] for x in range(0, 3 + 1) for y in range(1, 3 + 1)]

def get_distance(number, keypad):
	# 0 exception
	if number == 0:
		number = 11
	if keypad == 0:
		keypad = 11
	
	# to 0-base
	number -= 1 
	keypad -= 1

	if number > keypad:
		number, keypad = keypad, number
	return abs(dist[keypad][0] - dist[number][0]) + abs(dist[keypad][1] - dist[number][1])


def solution(numbers, hand):
	answer = ''
	
	cur_left, cur_right = 10, 12 # (*, #)

	for number in numbers:
		if number in [1, 4, 7]:
			answer += 'L'
			cur_left = number
		elif number in [3, 6, 9]:
			answer += 'R'
			cur_right = number
		else:
			l_dist, r_dist = get_distance(number, cur_left),\
							 get_distance(number, cur_right)
			if l_dist < r_dist:
				answer += 'L'
				cur_left = number
			elif l_dist > r_dist:
				answer += 'R'
				cur_right = number
			else:
				if hand == 'left':
					answer += 'L'
					cur_left = number
				else:
					answer += 'R'
					cur_right = number

		print('l, r: ', cur_left, cur_right)

	return answer

if __name__ == '__main__':
	print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))
	print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"))
	print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"))