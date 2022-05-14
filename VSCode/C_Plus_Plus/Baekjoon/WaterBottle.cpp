#include <iostream>
#include <cmath>

using namespace std;

int getCount(int n) {
    int count = 0;

    while(n > 0) {
        if(n % 2 != 0) ++count;
        n /= 2;
    }
    return count;
}

int main()
{
    int N, K;
    scanf("%d %d", &N, &K);
    if (N <= K)
    {
        printf("0\n");
        return 0;
    }

    int answer = -1;
    for(answer = N; ; ++answer) {
        if(getCount(answer) <= K){
            break;
        }
    }

    printf("%d\n", answer - N);

    return 0;
}