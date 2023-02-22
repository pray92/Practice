#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  cin.sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  int N;
  cin >> N;

  vector<int> numbers;
  for (int i = 0; i < N; ++i)
  {
    int a, b;
    cin >> a >> b;
    numbers.push_back(b - a);
  }
  sort(numbers.begin(), numbers.end());
  if (N % 2 != 0)
  {
    cout << 1 << endl;
  }
  else
  {
    size_t start = numbers.size() / 2 - 1;
    cout << numbers[start + 1] - numbers[start] + 1;
  }

  return 0;
}