#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) 
{
    unordered_map<string, int> playerInfo;
    for(string p : participant){
        playerInfo[p]++;
    }
    
    for(string c : completion){
        playerInfo[c]--;
    }

    string ret = "";
    for(const pair<string, int>& iter : playerInfo){
        if(iter.second > 0){
            ret = iter.first;
            break;
        }
    }
    return ret;
}

int main(){

    return 0;
}