

def reverse_str(li) -> None:
    # 공간 복잡도 O(1)을 고려한 트릭
    li[:] = li[::-1]

if __name__ == "__main__":
    a = ['a','b','c']
    reverse_str(a)
    print(a)