#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> a, vector<int> b) 
{
    if(a.size() != b.size())
        return 0;

    int answer = 0;

    for(size_t nIndex = 0 ; nIndex < a.size(); ++nIndex)
        answer += a[nIndex] * b[nIndex];

    return answer;
}

int main()
{
    cout << solution({1,2,3,4},{-3,-1,0,2}) << endl;
    cout << solution({-1,0,1}, {1,0,-1}) << endl;

    return 0;
}