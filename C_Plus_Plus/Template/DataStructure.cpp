#include <iostream>
#include <vector>

using namespace std;

template<typename T>
void print(const vector<T>& arr)
{
	for(const T& e : arr)
		cout << e << ',';
	cout << endl;
}

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
		m_heap[m_heapSize] = x;
		for(int i = m_heapSize; i > 0; i /= 2)
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
		++m_heapSize;
	}
	T pop()
	{
		T ret = m_heap[0];
		m_heap[0] = m_heap[m_heapSize];
		for(int i = 0; i * 2 < m_heapSize;)
		{
			// 두 자식들보다 큰 경우
			if(m_heap[i] > m_heap[i * 2 + 1] && m_heap[i] > m_heap[i * 2 + 2])	
				break;
			// 좌측이 더 큰 경우
			else if(m_heap[i * 2 + 1] >= m_heap[i * 2 + 2])
			{
				swap(m_heap[i], m_heap[i * 2 + 1]);
				i = i * 2 + 1;
			}
			// 우측이 더 큰 경우
			else
			{
				swap(m_heap[i], m_heap[i * 2 + 2]);
				i = i * 2 + 2;
			}
		}
		--m_heapSize;
		return ret;
	}

	void insertByHeapify(T x)
	{
		m_heap[m_heapSize++] = x;

		for(int i = m_heapSize / 2 - 1; i >= 0; --i){
			heapify(m_heapSize, i);
		}
	}

	T popByHeapify()
	{
		T ret = m_heap[0];
		m_heap[0] = m_heap[m_heapSize - 1];
		m_heap[m_heapSize--] = 0;
		
		heapify(m_heapSize, 0);

		return ret;
	}

	bool isEmpty() const {return m_heapSize <= 0;}

private:
	void heapify(int n, int i)
	{
		int parent = i;
		int lChild = i * 2 + 1;
		int rChild = i * 2 + 2;

		if(lChild < n && m_heap[parent] < m_heap[lChild])
			parent = lChild;
		if(rChild < n && m_heap[parent] < m_heap[rChild])
			parent = rChild;

		if(i != parent)
		{
			swap(m_heap[parent], m_heap[i]);
			heapify(n, parent);
		}
	}

private:
	int			m_heapSize = 0;
	vector<T> 	m_heap = vector<T>(100000);
};

int main()
{
	MaxHeap<int> heap;
	heap.insertByHeapify(4); heap.insertByHeapify(2); heap.insertByHeapify(1); heap.insertByHeapify(6);
	heap.insertByHeapify(3); heap.insertByHeapify(8); heap.insertByHeapify(11); heap.insertByHeapify(10);
	cout << "Extract" << endl;
	while(!heap.isEmpty())
		cout << heap.popByHeapify() << ", ";
	cout << endl;

	return 0;
}