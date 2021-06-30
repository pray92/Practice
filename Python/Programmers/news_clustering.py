import re
from collections import Counter

def make_list(target):
	str_list = []
	for i in range(0, len(target) - 1):
		str_list.append(target[i:i+2])
	return str_list
	


def solution(str1, str2):
	# 두칸씩 쪼갠 값이 모두 문자이면 str1, str2에 append 
	str1_list = [str1[i:i+2].lower() for i in range(0, len(str1)-1) if not re.findall('[^a-zA-Z]+', str1[i:i+2])]
	str2_list = [str2[i:i+2].lower() for i in range(0, len(str2)-1) if not re.findall('[^a-zA-Z]+', str2[i:i+2])]

	offset = 65536
	if str1 == str2:
		return offset
		
	str1_list, str2_list = sorted(str1_list), sorted(str2_list) 
	# 다중 집합이 아닌 경우 set으로 처리
	if (len(str1_list) == len(set(str1_list))) and (len(str2_list) == len(set(str2_list))):
		try:
			intersect = len(set(str1_list) & set(str2_list))
			union = len(set(str1_list) | set(str2_list))
			answer = intersect / union
			answer = int(answer * offset)
		except:
			answer = offset
	# 1. 각 list의 Counter 계산
	# 2. 계산한 Counter의 key를 전부 참조하면서 긴 값은 합집합, 짧은 값은 교집합에 저장
	# (둘 중에 하나에만 있는 경우는 합집합)
	# 부놈가 0인 경우엔 offset == 65536
	else:
		intersect, union = 0, 0
		counter1, counter2 = Counter(str1_list), Counter(str2_list)
		for i in set(list(counter1.keys()) + list(counter2.keys())):
			try:
				# 긴 값을 찾아서 긴 값을 union, 짧은 값을 inter에 저장
				if counter1[i] > counter2[i]:
					union += counter1[i]
					intersect += counter2[i]
				else:
					union += counter2[i] 
					intersect += counter1[i]
			# 다중집합에서도 하나의 집합에만 포함되는 경우는 union에만 저장
			except:
				if i in str1_list: union += counter1[i]
				else: union += counter2[i]
		try:
			answer = intersect / (union)
			answer = int(answer * offset)
		except:
			answer = 1
	return answer

if __name__ == '__main__':
	print(solution('FRANCE', 'french'))
	print(solution('handshake', 'shake hands'))
	print(solution('aa1+aa2', 'AAAA12'))
	print(solution('E=M*C^2', 'e=m*c^2'))