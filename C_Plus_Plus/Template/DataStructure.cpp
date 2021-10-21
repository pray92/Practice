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
			if(m_heap[i] > m_heap[i / 2])
			{
				swap(m_heap[i], m_heap[i / 2]);
			}
			else
			{
				break;
			}
		}
	}

	T pop()
	{
		T ret = m_heap[1];
		m_heap[1] = m_heap[m_heapSize--];
		for(int i = 1; i * 2 <= m_heapSize;)
		{
			// 두 자식들보다 큰 경우
			if(m_heap[i] > m_heap[i * 2] && m_heap[i] > m_heap[i * 2 + 1])	
				break;
			// 좌측이 더 큰 경우
			else if(m_heap[i * 2] >= m_heap[i * 2 + 1])
			{
				swap(m_heap[i], m_heap[i * 2]);
				i = i * 2;
			}
			// 우측이 더 큰 경우
			else
			{
				swap(m_heap[i], m_heap[i * 2 + 1]);
				i = i * 2 + 1;
			}
		}
	}

	bool isEmpty() const {return m_heapSize <= 1;}

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