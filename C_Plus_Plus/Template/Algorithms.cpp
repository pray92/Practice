#include <iostream>
#include <array>
#include <vector>
#include <climits>

using namespace std;

template<typename T>
class BubbleSort
{
public:
	static void sort(vector<T>& arr)
	{
		if(arr.size() <= 1)	return;

		for(int i = 0; i < arr.size(); ++i)
		{
			for(int j = 1; j < arr.size() - i; ++j)
			{
				if(arr[j] < arr[j - 1])
					swap(arr[j], arr[j - 1]);
			}
		}
	}
};

template<typename T>
class SelectionSort
{
public:
	static void sort(vector<T>& arr)	
	{
		if(arr.size() <= 1)	return;

		int minIndex = 0;
		for(int i = 0; i < arr.size() - 1; ++i)
		{
			minIndex = i;
			for(int j = i + 1; j < arr.size(); ++j)
			{
				if(arr[j] < arr[minIndex])
					minIndex = j;
			}
			swap(arr[i], arr[minIndex]);
		}
	}
};

template<typename T>
class InsertionSort
{
public:
	static void sort(vector<T>& arr)
	{
		for(int i = 1; i < arr.size(); ++i)
		{
			T tmp = arr[i];
			T prev = i - 1;
			while((prev >= 0) && (arr[prev] > tmp))
			{
				arr[prev + 1] = arr[prev];
				prev--;
			}
		}
	}
};

template<typename T>
class QuickSort
{
public:
	static void sort(vector<T>& arr)
	{
		if(arr.size() <= 1)
			return;
		
		quickSort(arr, 0, arr.size() - 1);
	}

private:
	static void quickSort(vector<T>& arr, int start, int end)
	{
		if(start >= end)
			return;

		int pivot = start;
		int left = pivot + 1;
		int right = end;
		
		while(left <= right)
		{
			while((arr[left] <= arr[pivot]) && (left <= end)) ++left;
			while((arr[pivot] < arr[right]) && (right > start)) --right;

			if(left > right) 
				swap(arr[pivot], arr[right]);
			else
				swap(arr[left], arr[right]);
		}
		// for(int i = start; i <= end; ++i)
		// 	cout << arr[i] << ", ";
		// cout << endl;

		quickSort(arr, start, right - 1);
		quickSort(arr, right + 1, end);
	}
};

template<typename T>
class MergeSort
{
public:
	static void sort(vector<T>& arr)
	{
		if(arr.size() <= 1)
			return;
		
		mergeSort(arr, 0, arr.size() - 1);
	}

private:
	static void mergeSort(vector<T>& arr, int left, int right)
	{
		if(left < right)
		{
			int mid = (left + right) / 2;

			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	static void merge(vector<T>& arr, int left, int mid, int right)
	{
		vector<T> L(arr.begin() + left, arr.begin() + mid + 1);
		vector<T> R(arr.begin() + mid + 1, arr.begin() + right + 1);

		int i = 0, j = 0, k = left;
		int ll = L.size(), rl = R.size();
		while(i < ll && j < rl)
		{
			if(L[i] <= R[j])
				arr[k] = L[i++];
			else
				arr[k] = R[j++];
			k++;
		}

		while(i < ll) arr[k++] = L[i++];
		while(j < rl) arr[k++] = R[j++];
	}
};

class CountingSort
{
public:
	static void sort(vector<int>& arr)
	{
		vector<int> ret(arr.size(), 0);
		
		// 배열의 사이즈를 최대 값으로(대략 1000000)
		vector<int> counting(1000000, 0);

		// 배열 값 증가
		for(int a : arr)
			counting[a]++;

		// 누적합으로 만들기
		for(int i = 1; i < counting.size(); ++i)
			counting[i] += counting[i - 1];
		
		// 역순환하면서 해당 값의 인덱스에 값 넣기
		for(int i = arr.size() - 1; i >= 0; --i)
		{
			ret[counting[arr[i]]] = arr[i];
			counting[arr[i]]--;
		}
		arr = ret;
	}
};

int main()
{
	vector<int> arr = { 8, 4, 11, 2, 3, 4, 9, 1, 6, 5};
	CountingSort::sort(arr);
	for(int a : arr)
		cout << a << ',';
	cout << endl;

	return 0;
}