#include <iostream>
#include<string>
using namespace std;

int solution(string s)
{
    int answer = 0;

    for(size_t nIndex = 0 ; nIndex < s.size() - 1; )
    {
        if(s.size() <= 1)
            break;

        if(s[nIndex] == s[nIndex + 1])
        {
            s.erase(s.begin() + nIndex);
            s.erase(s.begin() + nIndex);
            nIndex = 0;
        }
        else
        {
            ++nIndex;
        }
    }

    if(s.empty())
        answer = 1;

    return answer;
}

int main()
{
    cout << solution("baabaa") << endl;
    cout << solution("cdcd") << endl;

    return 0;
}