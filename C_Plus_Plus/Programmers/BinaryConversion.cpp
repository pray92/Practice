#include <iostream>
#include <string>
#include <vector>

using namespace std;

namespace
{
    string ToBinaryBySize(size_t size)
    {
        string ret;

        while(size > 0)
        {
            ret = static_cast<char>(size % 2 + '0') + ret;
            size -= size % 2;
            size /= 2;
        }

        return ret;
    }
}

vector<int> solution(string s) 
{
    vector<int> answer(2, 0);

    while(s != "1" && s.size() >= 1)
    {
        for(auto iter = s.begin() ; iter != s.end();)
        {
            if(*iter == '0')
            {
                iter = s.erase(iter);
                answer[1]++;
                continue;
            }
                
            ++iter;
        }

        s = ToBinaryBySize(s.size());
        ++answer[0];
        cout << s << endl;
    }

    return answer;
}

int main()
{
    vector<int> ret = solution("110010101001");
    cout << "[" << ret[0] << ", " << ret[1] << "]" << endl;
    ret = solution("01110");
    cout << "[" << ret[0] << ", " << ret[1] << "]" << endl;
    ret = solution("1111111");
    cout << "[" << ret[0] << ", " << ret[1] << "]" << endl;
  
    return 0;
}