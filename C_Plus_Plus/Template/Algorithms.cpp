#include <iostream>
#include <array>
#include <vector>

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

int main()
{
	vector<int> arr = { 8, 4, 11, 2, 3, 4, 9, 1, 6, 5};
	QuickSort<int>::sort(arr);
	for(int a : arr)
		cout << a << ',';
	cout << endl;
	

	return 0;
}