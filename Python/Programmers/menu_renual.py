
def solution(orders, course):
	mapping = dict()
	for i, order in enumerate(orders):
		for menu in order:
			try:
				mapping[menu].append(i)
			except:
				mapping[menu] = [i]

	answer = []

	return sorted(answer)

if __name__ == "__main__":
	print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2,3,4]))
	# print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2,3,5]))
	# print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))