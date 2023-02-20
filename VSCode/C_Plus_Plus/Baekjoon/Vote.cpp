#include <iostream>
#include <vector>

using namespace std;

bool isWin(vector<int> const &votes)
{
  int dasom = votes.front();
  for (size_t i = 1; i < votes.size(); ++i)
  {
    if (dasom <= votes[i])
    {
      return false;
    }
  }
  return true;
}

int main()
{
  cin.sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  int answer = 0;

  int N;
  cin >> N;
  if (1 >= N)
  {
    cout << answer << endl;
    return 0;
  }


  vector<int> votes(N, 0);
  for (int i = 0; i < N; ++i)
  {
    cin >> votes[i];
  }

  while (false == isWin(votes))
  {
    size_t maxIndex = 1;
    int maxVote = votes[1];
    for (size_t i = 2; i < votes.size(); ++i)
    {
      if (maxVote >= votes[i])
      {
        continue;
      }
      maxIndex = i;
      maxVote = votes[i];
    }
    
    ++votes[0];
    --votes[maxIndex];
    ++answer;
  }

  cout << answer << endl;
}
