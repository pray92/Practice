#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool IsMakable(vector<int> const& alphabets)
{
  bool isSingleOnce = false;
  for(int a : alphabets)
  {
    if(a % 2 == 0) {
      continue;
    }

    if(isSingleOnce) {
      return false;
    }

    isSingleOnce = true;
  }
  return true;
}

int main() 
{
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  string name;
  cin >> name;

  vector<int> alphabets('Z' - 'A' + 1, 0);
  for(char a : name)
    alphabets[a - 'A']++;
  
  if(false == IsMakable(alphabets))
  {
    cout << "I'm Sorry Hansoo" << endl;
    return 0;
  }

  string frontWord, midWord, endWord;
  for(size_t i = 0; i < alphabets.size(); ++i)
  {
    int alphabetCount = alphabets[i];
    if(0 >= alphabetCount)
    {
      continue;
    }

    char alphabet = char(i + 'A');

    for(int j = 0; j < (alphabetCount >> 1); ++j)
    {
      frontWord = frontWord + alphabet;
      endWord = alphabet + endWord;
    }
    if(alphabetCount % 2 != 0)
      midWord += alphabet;
  }
  string answer = frontWord + midWord + endWord;
  cout << answer << endl;

  return 0;
}