#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<vector<int>> maps)
{
    int answer = -1;
    if(maps.empty())
        return answer;

    vector<vector<bool>> done(maps.size(), vector<bool>(maps.begin()->size(), false));
    const int goalX = static_cast<int>(maps.begin()->size() - 1);
    const int goalY = static_cast<int>(maps.size() - 1);

    struct MoveInfo
    {
        int X;
        int Y;
        int Count;
    };
    const int moveX[] = {0, 0, 1, -1};
    const int moveY[] = {1, -1, 0, 0};

    queue<MoveInfo> q;
    q.push(MoveInfo{0, 0, 1});
    while(!q.empty())
    {
        const MoveInfo& info = q.front();
        const int curX = info.X;
        const int curY = info.Y;
        const int curCnt = info.Count;
        q.pop();

        if(0 < answer && answer <= curCnt)
            continue;

        if(curX == goalX && curY == goalY)
        {
            if(answer < 0)
                answer = curCnt;
            else
                answer = (curCnt < answer) ? curCnt : answer;
            
            continue;
        }

        for(int nAxisIndex = 0 ; nAxisIndex < 4; ++nAxisIndex)
        {
            const int nextX = curX + moveX[nAxisIndex];
            const int nextY = curY + moveY[nAxisIndex];
            if((0 <= nextX && nextX <= goalX) && (0 <= nextY && nextY <= goalY) )
            {
                if(!done[nextY][nextX] && maps[nextY][nextX] == 1)
                {
                    q.push(MoveInfo{nextX, nextY, curCnt + 1});
                    done[nextY][nextX] = true;
                }
            }
        }

    }

    return answer;
}

int main()
{
    cout << solution({{1,0,1,1,1},
                    {1,0,1,0,1},
                    {1,0,1,1,1},
                    {1,1,1,0,1},
                    {0,0,0,0,1} }) << endl;
    cout << solution({{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}) << endl;

    return 0;
}