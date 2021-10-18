#include <iostream>
#include <vector>

using namespace std;

template<typename T>
class MaxHeap
{
	// 1-base 기준
	// i : 부모
	// 2 * i : 좌측 자식
	// 2 * i + 1 : 우측 자식
public:
	void insert(T x)
	{
		m_heap[++m_heapSize] = x;

		for(int i = m_heapSize; i > 1; i /= 2)
		{
			if(m_heap[i / 2] < m_heap[i])
				swap(m_heap[i / 2], m_heap[i]);
			else
				break;
		}

		for(int nIndex = 1; nIndex < m_heapSize; ++nIndex)
		{
			T item = m_heap[nIndex];
			cout << item << ", ";
		}
		cout << endl;
	}

	T pop()
	{
		if(m_heapSize <= 0)
			return 0;

		int item = m_heap[1];
		m_heap[1] = m_heap[m_heapSize];		// 마지막 노드 값 루트 이동
		m_heap[m_heapSize--] = 0;			// 크기 줄이고 마지막 노드 0

		for(int i = 1; i * 2 <= m_heapSize;)
		{
			// 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 크면 끝
			if(m_heap[i] > m_heap[i * 2] && m_heap[i] > m_heap[i * 2 + 1])
			{
				break;
			}
			// 왼쪽 노드가 더 크면 swap
			else if(m_heap[i * 2] > m_heap[i * 2 + 1])
			{
				swap(m_heap[i], m_heap[i * 2]);
				i *= 2;
			}
			// 오른쪽이 더 큰 경우
			else /*if(m_heap[i * 2] < m_heap[i * 2 + 1])*/
			{
				swap(m_heap[i], m_heap[i * 2 + 1]);
				i = i * 2 + 1;
			}
		}

		return item;
	}

	bool isEmpty() const {return m_heapSize <= 0;}

private:
	int			m_heapSize = 0;
	vector<T> 	m_heap = vector<T>(100000);
};

int main()
{
	MaxHeap<int> heap;
	heap.insert(4); heap.insert(2); heap.insert(1); heap.insert(6);
	heap.insert(3); heap.insert(8); heap.insert(11); heap.insert(10);
	while(!heap.isEmpty())
		cout << heap.pop() << ", ";
	cout << endl;

	return 0;
}