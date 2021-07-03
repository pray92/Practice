
def get_tile(a, b):
    if a == '0' and b == '0':
        return ' '
    return '#'

def solution(n, arr1, arr2):
    answer = []
    
    for a1, a2 in zip(arr1, arr2):
        fmt = "{:0" + str(n) + "b}"
        a_map = fmt.format(a1)
        b_map = fmt.format(a2)
        answer.append(''.join([get_tile(x, y) for x, y in zip(a_map, b_map)]))
        

    return answer

if __name__ == '__main__':
    print(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))
    #print(solution(6, [46, 33, 33 ,22, 31, 50], [27 ,56, 19, 14, 14, 10]))