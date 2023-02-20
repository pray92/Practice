#include <iostream>
#include <vector>

using namespace std;


int main() {
    int N;
    scanf("%d", &N);

    vector<vector<int> > cost(N, vector<int>(3, 0));
    for(int i = 0; i < N ;++i)
    {
        int r, g, b;
        scanf("%d %d %d", &r, &g, &b);
        if(i == 0){
            cost[i][0] = r;
            cost[i][1] = g;
            cost[i][2] = b;
        } else {
            cost[i][0] = r + min(cost[i - 1][1],cost[i - 1][2]);
            cost[i][1] = g + min(cost[i - 1][0],cost[i - 1][2]);
            cost[i][2] = b + min(cost[i - 1][0],cost[i - 1][1]);
        }
    }
    printf("%d\n", min(cost[N - 1][0], min(cost[N - 1][1], cost[N - 1][2])));

    return 0;
}