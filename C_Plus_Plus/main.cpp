#include <iostream>
#include <string>
#include <vector>
using namespace std;

namespace
{
    int GetDivisorCount(int value)
    {
        int ret = 0;
        for(int n = 1; n <= value; ++n)
        {
            if(value % n == 0)
                ++ret;
        }
        
        return ret;
    }
}

int solution(int left, int right) 
{
    int answer = 0;
    
    for(int num = left; num <= right ; ++num)
    {
        int nCnt = GetDivisorCount(num);
        if (nCnt % 2 == 0)
            answer += num;
        else 
            answer -= num;

    }        

    
    return answer;
}

#include <cmath>

using namespace std;

namespace
{
    long long GetResult(long long number)
    {
        long long ret = 0;
        if(number % 4 < 3)
        {
            ret = number + 1;
        }
        else
        {
            int offsetExp = 0;
            while((long long)pow(2, offsetExp) < number) 
                ++offsetExp;
            
            int nOffsetExp2 = offsetExp;

            long long tmpNumber = number;
            for(int nOffset = 0; nOffset <= offsetExp; ++nOffset)
            {
                if(tmpNumber % 2 == 0)
                {
                    nOffsetExp2  = nOffset;
                    break;
                }

                tmpNumber /= 2;
            }

            cout << "offset : " << nOffsetExp2 << endl;
            ret = number + (long long)pow(2, nOffsetExp2) -  (long long)pow(2, nOffsetExp2 - 1);
        }
        return ret;
    }
}

vector<long long> solution(vector<long long> numbers) 
{
    vector<long long> answer;

    for (const long long& number : numbers)
    {
        answer.push_back(GetResult(number));
    }

    return answer;
}


#include <map>

using namespace std;

namespace
{
    map<int, vector<int>> TreeMap;
    map<int, int> ParentMap;
    vector<int> Nodes;

    void GetSum(long long& ret, const int curNode)
    {
        if(TreeMap.end() == TreeMap.find(curNode))
            return;
        
        for(const int& childNode : TreeMap[curNode])
        {
            ret += Nodes[childNode];
            GetSum(ret, childNode);
        }
    }
}

vector<long long> solution(vector<int> values, vector<vector<int>> edges, vector<vector<int>> queries) 
{
    vector<long long> answer;

    Nodes = {0, }; Nodes.insert(Nodes.end(), values.begin(), values.end());

    for(const vector<int>& edge : edges)
    {
        TreeMap[edge[0]].push_back(edge[1]);
        ParentMap[edge[1]] = edge[0];
    }

    for(const vector<int>& query : queries)
    {
        const int u = query[0];
        const int w = query[1];
        if(w == -1)
        {
            long long ret = Nodes[u];
            GetSum(ret, u);
            answer.push_back(ret);
        }
        else
        {
            for(int nCur = u; ParentMap.end() != ParentMap.find(nCur); nCur = ParentMap[nCur])
            {
                Nodes[nCur] = ParentMap[nCur];
            }
            Nodes[1] = w;
        }
    }

    return answer;
}

int main()
{
    auto ret = solution({951, 7, 1});
    cout << ret[0] << ", " << ret[1] << ", " << ret[2] << endl;
    return 0;
}