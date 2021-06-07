#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times)
{
    sort(times.begin(), times.end());

    long long answer = 0;
    long long left = 1;                 // 최소
    long long right = times.back() * n; // 최대
    long long mid;
    while(left <= right)
    {
        mid = (left + right) / 2;
        
        long long count = 0;
        for (int time : times)
            count += mid / time;

        if(count >= n)
        {
            if(answer > mid)
                answer = mid;
            right = mid - 1;
        }
        else
            left = mid + 1;
    }

    return answer;
}

int main()
{
    cout << solution(6, {7, 10}) << endl;

    return 0;
}