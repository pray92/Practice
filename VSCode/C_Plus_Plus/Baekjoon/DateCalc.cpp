#include <iostream>

using namespace std;

int main()
{
  cin.sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  int E, S, M;
  cin >> E >> S >> M;

  int answer = 1;
  int e = 1, s = 1, m = 1;
  while (E != e || S != s || M != m)
  {
    e = (e % 15) + 1;
    s = (s % 28) + 1;
    m = (m % 19) + 1;
    ++answer;
  }

  cout << answer << endl;
}