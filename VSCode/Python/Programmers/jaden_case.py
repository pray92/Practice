
def solution(s):
	answer = s.split(' ')
	answer = [x.capitalize() for x in answer]
	
	return ' '.join(answer)

if '__main__' == __name__:
	print(solution("3people unFollowed me"))
	print(solution("For The Last Week"))
	