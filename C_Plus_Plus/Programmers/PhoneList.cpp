#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) 
{
    if(phone_book.size() <= 1)
        return true;

    // string을 정렬합니다.
    sort(phone_book.begin(), phone_book.end());

    // 이전 전화번호의 접두어일 경우 false!
    for(size_t nIndex = 1; nIndex < phone_book.size(); ++nIndex)
    {
        if(phone_book[nIndex].find( phone_book[nIndex - 1]) == 0)
            return false;
    }

    return true;
}

int main()
{
    if(solution({"119", "97674223", "1195524421",})) cout <<  "true" << endl; else cout <<  "false" << endl;
    if(solution({"123","456","789"})) cout <<  "true" << endl; else cout <<  "false" << endl;
    if(solution({"12","123","1235","567","88"})) cout <<  "true" << endl; else cout <<  "false" << endl;
    if(solution({"45", "123","789", "125234"})) cout <<  "true" << endl; else cout <<  "false" << endl;
    if(solution({"45", "456"})) cout <<  "true" << endl; else cout <<  "false" << endl;

    return 0;
}