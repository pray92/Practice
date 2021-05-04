#include <iostream>
#include <string>
#include <stack>

using namespace std;

#if PENDING // 효율성 실패
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
#endif

int solution(string s)
{
    int answer = 0;
    // 홀수는 무조건 하나가 남습니다.
    if(s.empty() || s.size() % 2 != 0)
        return answer;

    stack<char> stk;
    for(size_t nIndex = 0; nIndex < s.size() ; ++nIndex)
    {
        if(stk.empty() || stk.top() != s[nIndex])
            stk.push(s[nIndex]);
        else
            stk.pop();
        
    }

    if(stk.empty())
        ++answer;

    return answer;
}

int main()
{
    cout << solution("baabaa") << endl;
    cout << solution("cdcd") << endl;
    cout << solution("aabb") << endl;
    cout << solution("aabbccddbbaadd") << endl;

    return 0;
}