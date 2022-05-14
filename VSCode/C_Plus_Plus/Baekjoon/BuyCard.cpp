#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N;
    scanf("%d", &N);
    vector<int> cards(N + 1);
    for (int i = 1; i <= N; ++i)
    {
        scanf("%d", &cards[i]);
    }

    vector<int> dp(N + 1);
    for(int i = 1; i <= N; ++i){
        for(int j = 1; j <= i; ++j)
        {
            dp[i] = max(dp[i], cards[j] + dp[i - j]);
        }
    }

    printf("%d\n", dp[N]);

    return 0;
}